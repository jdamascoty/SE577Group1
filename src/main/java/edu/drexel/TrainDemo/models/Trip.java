package edu.drexel.TrainDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String headsign;
	@Column(name = "route_id")
	private Long route;
	@Column(name = "calendar_id")
	private Long calendar;
	private Long direction;

	public Long getRoute() {
		return route;
	}

	public void setRoute(Long route) {
		this.route = route;
	}

	public Long getCalendar() {
		return calendar;
	}

	public void setCalendar(Long calendar) {
		this.calendar = calendar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeadsign() {
		return headsign;
	}

	public void setHeadsign(String headsign) {
		this.headsign = headsign;
	}

	public Long getDirection() {
		return direction;
	}

	public void setDirection(Long direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", headsign=" + headsign + ", direction=" + direction + ", route_id=" + route
				+ ", calendar_id=" + calendar + "]";
	}

}
