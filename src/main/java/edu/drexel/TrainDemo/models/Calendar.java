package edu.drexel.TrainDemo.models;

import java.sql.Date;
import java.util.ArrayList;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	@Column(name = "start_date")
	private Date start_date;
	@Column(name = "end_date")
	private Date end_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThursday() {
		return thursday;
	}

	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public boolean isDay(String day) {
		if (day.equals("sunday")) {
			return sunday;
		} else if (day.equals("monday")) {
			return monday;
		} else if (day.equals("tuesday")) {
			return tuesday;
		} else if (day.equals("wednesday")) {
			return wednesday;
		} else if (day.equals("thursday")) {
			return thursday;
		} else if (day.equals("friday")) {
			return friday;
		} else if (day.equals("saturday")) {
			return saturday;
		} else
			return false;

	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}

	public ArrayList<Boolean> valueListOfDays() {
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		list.add(sunday);
		list.add(monday);
		list.add(tuesday);
		list.add(wednesday);
		list.add(thursday);
		list.add(friday);
		list.add(saturday);
		;

		return list;
	}

}
