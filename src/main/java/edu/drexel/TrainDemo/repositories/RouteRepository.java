package edu.drexel.TrainDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.Route;

public interface RouteRepository extends CrudRepository<Route, Long> {
	List<Route> findByAgencyId(long agencyId);
}