package edu.drexel.TrainDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.Agency;

public interface AgencyRepository extends CrudRepository<Agency, Long> {

}
