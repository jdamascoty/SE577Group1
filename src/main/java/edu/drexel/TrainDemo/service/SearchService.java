package edu.drexel.TrainDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.StopTimeResultSet;
import edu.drexel.TrainDemo.repositories.CalendarRepository;
import edu.drexel.TrainDemo.repositories.RouteRepository;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.repositories.StopTimeRepository;
import edu.drexel.TrainDemo.repositories.TripRepository;

@Service
public class SearchService {
	@Autowired
	private StopTimeRepository stopTimeRepository;
	@Autowired
	private TripRepository tripRepository;
	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private CalendarRepository calendarRepository;
	@Autowired
	private StopRepository stopRepository;

	public void searchOneWay(String fromStop, String toStop, String date) {

		List<StopTimeResultSet> TripsBetweenTwoStops = getStopsTimesBetweenTwo(fromStop, toStop, date);

	}

	public String translation(String stationName) {

		String result = null;
		List<Stop> resultList = stopRepository.findByName(stationName);
		if (resultList.size() == 0) {
		} else
			result = resultList.get(0).getId();

		return result;
	}

	public List<StopTimeResultSet> getStopsTimesBetweenTwo(String fromStop, String toStop, String date) {

		List<StopTime> fromTime = stopTimeRepository.findByStopId(fromStop);
		List<StopTime> toTime = stopTimeRepository.findByStopId(toStop);
		List<StopTimeResultSet> results = new ArrayList<StopTimeResultSet>();
//		System.out.println("FromTimeResults " + fromTime.size());
//		System.out.println("toTimeResults " + toTime.size());
		fromTime.forEach(fromTimeResults -> {
			toTime.forEach(toTimeResult -> {

				if (fromTimeResults.getTripId().equals(toTimeResult.getTripId())) {
					if (fromTimeResults.getStopSequence() < toTimeResult.getStopSequence()) {

						StopTimeResultSet str = new StopTimeResultSet();
						str.setStopId(fromTimeResults.getStopId());
						str.setToId(toTimeResult.getStopId());
						str.setArrival_time(fromTimeResults.getArrival_time());
						str.setDeparture_time(toTimeResult.getArrival_time());
						str.setStopSequence(toTimeResult.getStopSequence());
						str.setTripId(fromTimeResults.getTripId());
						results.add(str);
					}
				}

			});
		});

		displayToConsole(results);
		return results;
	}

	private void displayToConsole(List<StopTimeResultSet> results) {

		results.forEach(result -> {
			System.out.println(result.getStopId() + " " + result.getToId() + " " + result.getArrival_time() + " "
					+ result.getDeparture_time() + " " + result.getStopSequence() + " " + result.getTripId());
		});

	}
	

}