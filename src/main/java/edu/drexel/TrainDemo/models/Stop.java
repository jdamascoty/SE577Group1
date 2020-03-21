package edu.drexel.TrainDemo.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stop {

	@Id
	private String id;
	private String name;
	private String externalUrl;
	private BigDecimal lat;
	private BigDecimal lon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Stop [id=" + id + ", name=" + name + ", externalUrl=" + externalUrl + ", lat=" + lat + ", lon=" + lon
				+ "]";
	}
	
}
