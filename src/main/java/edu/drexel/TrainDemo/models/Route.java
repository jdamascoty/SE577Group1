package edu.drexel.TrainDemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private RouteType routeType;
	private String externalUrl;

	@ManyToOne
	private Agency agency;

	protected Route() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public Agency getAgency() {
		return agency;
	}

	@Override
	public String toString() {
		return "Route{" + "id=" + id + ", name='" + name + '\'' + ", routeType=" + routeType + ", externalUrl='"
				+ externalUrl + '\'' + ", agency=" + agency + '}';
	}
}