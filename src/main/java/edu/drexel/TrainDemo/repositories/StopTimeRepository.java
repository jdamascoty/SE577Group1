package edu.drexel.TrainDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.StopTimeComposite;

public interface StopTimeRepository extends CrudRepository<StopTime, StopTimeComposite> {
	List<StopTime> findByStopId(String fromStop);

	List<StopTime> findByStopIdAndTripId(String fromStop, Long tripId);
}
