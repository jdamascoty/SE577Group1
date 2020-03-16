package edu.drexel.TrainDemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.models.Calendar;
import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.Trip;
import edu.drexel.TrainDemo.repositories.CalendarRepository;
import edu.drexel.TrainDemo.repositories.RouteRepository;
import edu.drexel.TrainDemo.repositories.StopTimeRepository;
import edu.drexel.TrainDemo.repositories.TripRepository;

@Service
public class OneWaySearchService {

	@Autowired
	private StopTimeRepository stoptimeRepository;

	@Autowired
	private TripRepository tripRepository;

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private CalendarRepository calendarRepository;

	public void searchOneWay(String fromStop, String toStop, String date) {

		List<Map<String, StopTime>> TripsBetweenTwoStops = getStopsTimesBetweenTwo(fromStop, toStop, date);

	}

	public List<Map<String, StopTime>> getStopsTimesBetweenTwo(String fromStop, String toStop, String date) {
		List<StopTime> fromstoptimes = stoptimeRepository.findByStopId(fromStop);
		for (StopTime stoptime : fromstoptimes) {
			System.out.println(stoptime);
		}
		List<StopTime> tostoptimes = stoptimeRepository.findByStopId(toStop);
		List<Map<String, StopTime>> filteredStops = new ArrayList<Map<String, StopTime>>();
		System.out.println("size from one" + fromstoptimes.size());
		System.out.println("size to one" + tostoptimes.size());
		List<Long> tripIdlist = new ArrayList<Long>();
		if (fromstoptimes != null && tostoptimes != null) {
			fromstoptimes.forEach(fromStopTime -> {
				tostoptimes.forEach(toStopTime -> {
					if (fromStopTime.getTripId().equals(toStopTime.getTripId())
							&& (fromStopTime.getStopSequence() - toStopTime.getStopSequence()) < 0) {
						tripIdlist.add(fromStopTime.getTripId());
						Map<String, StopTime> startAndEndStopTimes = new LinkedHashMap<String, StopTime>();
						startAndEndStopTimes.put("fromStop", fromStopTime);
						startAndEndStopTimes.put("toStop", toStopTime);
						filteredStops.add(startAndEndStopTimes);

					}
				});
			});
		}

		tostoptimes.forEach(t -> System.out.println(t));
		System.out.println("filtered stops" + filteredStops.size());
		filteredStops.forEach(t -> System.out
				.println(t.get("fromStop").getDeparture_time() + "====" + t.get("toStop").getArrival_time()));
		filterBytrip(filteredStops, date);
		return filteredStops;
	}

	public void filterBytrip(List<Map<String, StopTime>> stopList, String date) {
		List<Trip> filteredfromStoplist = new ArrayList<Trip>();
		List<Trip> filteredtoStoplist = new ArrayList<Trip>();
		List<Trip> calenderFromStopfilteredlist = new ArrayList<Trip>();
		List<Route> filteredbyroutelist = new ArrayList<Route>();

		stopList.forEach(stop -> {
			StopTime fromStop = stop.get("fromStop");
			Optional<Trip> findByTripList = tripRepository.findById(fromStop.getTripId());
			findByTripList.ifPresent(trip -> {
				filteredfromStoplist.add(trip);
			});

		});

		stopList.forEach(stop -> {
			StopTime fromStop = stop.get("toStop");
			Optional<Trip> findByTripList = tripRepository.findById(fromStop.getTripId());
			findByTripList.ifPresent(trip -> {
				filteredtoStoplist.add(trip);
			});

		});

		filteredfromStoplist.forEach(t -> System.out.println(t));
		// calendar filter
		System.out.println("date is isssss" + date);
		if (date != null) {
			calenderFromStopfilteredlist = filteredfromStoplist.stream().filter(t -> {
				Optional<Calendar> optionalcalendar = calendarRepository.findById(t.getCalendar());
				Calendar calendar = null;
				if (optionalcalendar.isPresent()) {
					calendar = optionalcalendar.get();
				}
				try {
					System.out.println("day isssss" + getDayBydate(date));
					return calendar.isDay(getDayBydate(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return false;

			}).collect(Collectors.toList());
		}
		System.out.println("calender filtered list");
		calenderFromStopfilteredlist.forEach(t -> System.out.println(t));
		System.out.println("calender filtered list ends");
		calenderFromStopfilteredlist.forEach(t -> System.out.println(t));
		List<Long> routeList = new ArrayList<>();
		calenderFromStopfilteredlist.forEach(t -> {
			routeList.add(t.getRoute());
		});
		filteredfromStoplist.forEach(t -> {
			Iterable<Route> routefilteredList = routeRepository.findAllById(routeList);
			routefilteredList.forEach(temp -> {
				filteredbyroutelist.add(temp);
			});
		});
		System.out.println("=============== routes" + filteredbyroutelist.size());
		filteredbyroutelist.forEach(t -> System.out.println(t));

		List<Route> agencyFilteredList = filteredbyroutelist.stream().filter(t -> t.getAgencyId() == 51)
				.collect(Collectors.toList());

		System.out.println("================finally filtered list========================");
		agencyFilteredList.forEach(t -> System.out.println(t));
		System.out.println("================finally filtered list ends========================size was"
				+ agencyFilteredList.size());

	}

	public String getDayBydate(String date) throws ParseException {

		String dateString = String.format(date);
		Date datee = new SimpleDateFormat("dd-mm-yyyy").parse(dateString);

		// Then get the day of week from the Date based on specific locale.
		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(datee);
		if (dayOfWeek.toLowerCase().equals("wednesday")) {
			return "sunday";
		} else if (dayOfWeek.toLowerCase().equals("thursday")) {
			return "monday";
		} else if (dayOfWeek.toLowerCase().equals("friday")) {
			return "tuesday";
		} else if (dayOfWeek.toLowerCase().equals("saturday")) {
			return "wednesday";
		} else if (dayOfWeek.toLowerCase().equals("sunday")) {
			return "thursday";
		} else if (dayOfWeek.toLowerCase().equals("monday")) {
			return "friday";
		} else {
			return "saturday";
		}

	}

}