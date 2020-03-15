package edu.drexel.TrainDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.Stop;

public interface StopRepository extends CrudRepository<Stop, Long> {

}
