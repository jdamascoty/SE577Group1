package edu.drexel.TrainDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {
	List<Trip> findByHeadsign(String headSign);
}
