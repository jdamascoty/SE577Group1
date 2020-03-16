package edu.drexel.TrainDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "route_type")
	private Long routeType;

	@Column(name = "external_url")
	private String externalUrl;

	@Column(name = "agency_id")
	private Long agencyId;

	protected Route() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getRouteType() {
		return routeType;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRouteType(Long routeType) {
		this.routeType = routeType;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	@Override
	public String toString() {
		return "Route{" + "id=" + id + ", name='" + name + '\'' + ", routeType=" + routeType + ", externalUrl='"
				+ externalUrl + '\'' + ", agencyId=" + agencyId + '}';
	}
}