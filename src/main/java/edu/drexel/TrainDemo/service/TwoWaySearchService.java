package edu.drexel.TrainDemo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import edu.drexel.TrainDemo.utils.SearchResult;

@Service
public class TwoWaySearchService {

	@Autowired
	private StopTimeRepository stoptimeRepository;

	@Autowired
	private TripRepository tripRepository;

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private CalendarRepository calendarRepository;

	@Autowired
	private OneWaySearchService searchService;

	public List<SearchResult> searchOneWay(String fromStop, String toStop, String date) {
		List<SearchResult> searchResultList = new ArrayList<SearchResult>();
		List<StopTime> fromStopTimeListfromrepository = stoptimeRepository.findByStopId(fromStop);
		fromStopTimeListfromrepository.forEach(t -> System.out.println(t));
		fromStopTimeListfromrepository.forEach(stoptimeParam -> {
			List<StopTime> toStopList = stoptimeRepository.findByStopIdAndTripId(toStop, stoptimeParam.getTripId());
			System.out.println("0000000toStopList------for " + stoptimeParam + "is--" + toStopList);
			if (!toStopList.isEmpty()) {
				System.out.println("entered");
				StopTime tostopTime = toStopList.get(0);
				System.out.println("fetched to" + tostopTime);
				Optional<Trip> tripObject = tripRepository.findById(tostopTime.getTripId());
				tripObject.ifPresent(tripParam -> {
					Optional<Calendar> calendarObject = calendarRepository.findById(tripParam.getCalendar());
					calendarObject.ifPresent(calendarParam -> {
						try {
							if (calendarParam.isDay(searchService.getDayBydate(date))) {
								Optional<Route> routeObject = routeRepository.findById(tripParam.getRoute());
								routeObject.ifPresent(routeParam -> {
									SearchResult result = new SearchResult();
									result.setFromStop(fromStop);
									result.setToStop(toStop);
									result.setNameOfTheTrain(routeParam.getName());
									result.setArrivalTime(stoptimeParam.getArrival_time());
									result.setDepartureTime(tostopTime.getDeparture_time());
									searchResultList.add(result);
								});
							}
						} catch (ParseException e) {
							e.printStackTrace();
						}
					});
				});
			}
		});
		System.out.println("start");
		searchResultList.forEach(t -> System.out.println(t));
		System.out.println("end");
		return searchResultList;
	}

	public Map<String, List<SearchResult>> searchRoundTrip(String fromStop, String toStop, String journeyDate,
			String returnJourneyDate) {
		List<SearchResult> firstJourneyList = searchOneWay(fromStop, toStop, journeyDate);
		List<SearchResult> returnJourneyList = searchOneWay(toStop, fromStop, returnJourneyDate);
		Map<String, List<SearchResult>> results = new HashMap<String, List<SearchResult>>();
		results.put("firstJourneyList", firstJourneyList);
		results.put("returnJourneyList", returnJourneyList);
		return results;

	}
}