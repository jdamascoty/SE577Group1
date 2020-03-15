package edu.drexel.TrainDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.models.Calendar;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {

}
