package edu.drexel.TrainDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "monday")
	private Boolean monAvailability;

	@Column(name = "tuesday")
	private Boolean tuesAvailability;

	@Column(name = "wednesday")
	private Boolean wedAvailability;

	@Column(name = "thursday")
	private Boolean thursAvailability;

	@Column(name = "friday")
	private Boolean friAvailability;

	@Column(name = "saturday")
	private Boolean satAvailability;

	@Column(name = "sunday")
	private Boolean sunAvailability;

	private String startDate;
	private String endDate;

	public Long getId() {
		return id;
	}

	public Boolean getMonAvailability() {
		return monAvailability;
	}

	public Boolean getTuesAvailability() {
		return tuesAvailability;
	}

	public Boolean getWedAvailability() {
		return wedAvailability;
	}

	public Boolean getThursAvailability() {
		return thursAvailability;
	}

	public Boolean getFriAvailability() {
		return friAvailability;
	}

	public Boolean getSatAvailability() {
		return satAvailability;
	}

	public Boolean getSunAvailability() {
		return sunAvailability;
	}
}
