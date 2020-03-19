package edu.drexel.TrainDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(StopTimeComposite.class)
public class StopTime {

	@Id
	@Column(name = "stop_id")
	private String stopId;
	@Column(name = "trip_id")
	private Long tripId;
	@Column(name = "stop_sequence")
	private int stopSequence;

	private String departure_time;
	private String arrival_time;
	private int pickup_type;
	private int dropoff_type;

	public int getStopSequence() {
		return stopSequence;
	}

	public void setStop_sequence(int stopSequence) {
		this.stopSequence = stopSequence;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getPickup_type() {
		return pickup_type;
	}

	public void setPickup_type(int pickup_type) {
		this.pickup_type = pickup_type;
	}

	public int getDropoff_type() {
		return dropoff_type;
	}

	public void setDropoff_type(int dropoff_type) {
		this.dropoff_type = dropoff_type;
	}

	public String getStopId() {
		return stopId;
	}

	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	@Override
	public String toString() {
		return "StopTime [stopId=" + stopId + ", tripId=" + tripId + ", stopSequence=" + stopSequence
				+ ", departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", pickup_type="
				+ pickup_type + ", dropoff_type=" + dropoff_type + "]";
	}

}
