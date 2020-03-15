package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {
    List<Route> findByAgency_Id(long agencyId);
}