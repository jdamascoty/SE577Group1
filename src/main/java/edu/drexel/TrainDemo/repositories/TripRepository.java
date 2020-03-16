package edu.drexel.TrainDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
