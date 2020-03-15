package edu.drexel.TrainDemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id; // e.g. ANA for Anaheim, RGH for Raleigh...
	private String name;
	private float lat;
	private float lon;
	private String externalUrl;

	protected Stop() {
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getLat() {
		return lat;
	}

	public float getLon() {
		return lon;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	@Override
	public String toString() {
		return "Stop{" + "id=" + id + ", name=" + name + ", lat=" + lat + ", lon=" + lon + ", externalUrl="
				+ externalUrl + "}";
	}
}
