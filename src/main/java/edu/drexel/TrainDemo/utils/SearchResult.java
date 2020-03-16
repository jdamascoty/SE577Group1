package edu.drexel.TrainDemo.utils;

public class SearchResult {
	String fromStop;
	String toStop;
	String arrivalTime;
	String departureTime;
	String nameOfTheTrain;
	int price;
	String duration;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "SearchResult [fromStop=" + fromStop + ", toStop=" + toStop + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", nameOfTheTrain=" + nameOfTheTrain + ", price=" + price
				+ ", duration=" + duration + ", agency=" + agency + "]";
	}
	String agency;
	public String getFromStop() {
		return fromStop;
	}
	public void setFromStop(String fromStop) {
		this.fromStop = fromStop;
	}
	public String getToStop() {
		return toStop;
	}
	public void setToStop(String toStop) {
		this.toStop = toStop;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getNameOfTheTrain() {
		return nameOfTheTrain;
	}
	public void setNameOfTheTrain(String nameOfTheTrain) {
		this.nameOfTheTrain = nameOfTheTrain;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}

}
