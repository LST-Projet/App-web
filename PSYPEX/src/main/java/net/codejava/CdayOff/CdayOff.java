package net.codejava.CdayOff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.codejava.Clistcust.Clistcust;

@Entity
@Table(name = "cday_off")
public class CdayOff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_lunar_day")
	private boolean Lday;
	
	@Column(name = "day")
	private int day;
	
	@Column(name = "month")
	private int month;
	
	@Column(name = "year")
	private int year;
	
	@OneToOne
	@JoinColumn(name = "place_id")
	private Clistcust place;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLday() {
		return Lday;
	}

	public void setLday(boolean lday) {
		Lday = lday;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Clistcust getPlace() {
		return place;
	}

	public void setPlace(Clistcust place) {
		this.place = place;
	}

	public CdayOff() {	}
	
	
}
