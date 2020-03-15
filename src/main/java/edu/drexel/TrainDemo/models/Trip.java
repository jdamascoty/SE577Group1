package edu.drexel.TrainDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "headsign")
	private String headSign;

	// TO-DO: direction datatype?
	// private Direction direction;

	@ManyToOne
	private Route route;

	@ManyToOne
	private Calendar calendar;

	protected Trip() {

	}

	public Long getId() {
		return id;
	}

	public String getHeadSign() {
		return headSign;
	}

	public Route getRoute() {
		return route;
	}

	public Calendar getCalendar() {
		return calendar;
	}
}
