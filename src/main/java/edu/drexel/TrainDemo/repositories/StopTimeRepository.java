package edu.drexel.TrainDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.StopTime;

public interface StopTimeRepository extends CrudRepository<StopTime, Long> {
	List<StopTime> findByStopId(long stopId);

	List<StopTime> findByTripId(long tripId);
}
