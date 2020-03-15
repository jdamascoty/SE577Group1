package edu.drexel.TrainDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stop_time")
public class StopTime {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Stop stop;

	@ManyToOne
	private Trip trip;

	@Column(name = "stop_sequence")
	private Integer sequenceNumber;

	// TO-DO: arrivalTime and departureTime datatype?
	// private Time arrivalTime;
	// private TIme departureTime;

	@Column(name = "pickup_type")
	private Boolean pickupType;

	@Column(name = "dropoff_type")
	private Boolean dropoffType;

	public Stop getStop() {
		return stop;
	}

	public Trip getTrip() {
		return trip;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public Boolean getPickupType() {
		return pickupType;
	}

	public Boolean getDropoffType() {
		return dropoffType;
	}

}
