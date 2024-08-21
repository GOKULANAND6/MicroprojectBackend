package com.micro.claim.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "car")
public class Car 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int car_id;
	private String car_make;
	private String car_name;
	private String car_model;
	private String car_year;
	private Date car_buyingdate;
	private String car_number;
	
	public Car() 
	{
		super();
	}

	public Car(int car_id, String car_make, String car_name, String car_model, String car_year, Date car_buyingdate,
			String car_number) {
		super();
		this.car_id = car_id;
		this.car_make = car_make;
		this.car_name = car_name;
		this.car_model = car_model;
		this.car_year = car_year;
		this.car_buyingdate = car_buyingdate;
		this.car_number = car_number;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getCar_make() {
		return car_make;
	}

	public void setCar_make(String car_make) {
		this.car_make = car_make;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public String getCar_year() {
		return car_year;
	}

	public void setCar_year(String car_year) {
		this.car_year = car_year;
	}

	public Date getCar_buyingdate() {
		return car_buyingdate;
	}

	public void setCar_buyingdate(Date car_buyingdate) {
		this.car_buyingdate = car_buyingdate;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_make=" + car_make + ", car_name=" + car_name + ", car_model="
				+ car_model + ", car_year=" + car_year + ", car_buyingdate=" + car_buyingdate + ", car_number="
				+ car_number + "]";
	}	
}
