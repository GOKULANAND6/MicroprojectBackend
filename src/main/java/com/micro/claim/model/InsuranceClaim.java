package com.micro.claim.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "claimdetails")
public class InsuranceClaim 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int claim_id;
	private String claim_issue;
	private String car_make;
	private String car_name;
	private String car_model;
	private String car_year;
	private String car_buyingdate;
	private String car_number;
	private String claim_status;
	
	
	@OneToOne(targetEntity = CarInsurance.class, cascade = CascadeType.ALL)
	private CarInsurance carinsurance;
	
	public InsuranceClaim() 
	{
		super();
	}

	public InsuranceClaim(int claim_id, String claim_issue, String car_make, String car_name, String car_model,
			String car_year, String car_buyingdate, String car_number, String claim_status, CarInsurance carinsurance) {
		super();
		this.claim_id = claim_id;
		this.claim_issue = claim_issue;
		this.car_make = car_make;
		this.car_name = car_name;
		this.car_model = car_model;
		this.car_year = car_year;
		this.car_buyingdate = car_buyingdate;
		this.car_number = car_number;
		this.claim_status = claim_status;
		this.carinsurance = carinsurance;
	}

	public int getClaim_id() {
		return claim_id;
	}

	public void setClaim_id(int claim_id) {
		this.claim_id = claim_id;
	}

	public String getClaim_issue() {
		return claim_issue;
	}

	public void setClaim_issue(String claim_issue) {
		this.claim_issue = claim_issue;
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

	public String getCar_buyingdate() {
		return car_buyingdate;
	}

	public void setCar_buyingdate(String car_buyingdate) {
		this.car_buyingdate = car_buyingdate;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public String getClaim_status() {
		return claim_status;
	}

	public void setClaim_status(String claim_status) {
		this.claim_status = claim_status;
	}

	public CarInsurance getCarinsurance() {
		return carinsurance;
	}

	public void setCarinsurance(CarInsurance carinsurance) {
		this.carinsurance = carinsurance;
	}

	@Override
	public String toString() {
		return "InsuranceClaim [claim_id=" + claim_id + ", claim_issue=" + claim_issue + ", car_make=" + car_make
				+ ", car_name=" + car_name + ", car_model=" + car_model + ", car_year=" + car_year + ", car_buyingdate="
				+ car_buyingdate + ", car_number=" + car_number + ", claim_status=" + claim_status + ", carinsurance="
				+ carinsurance + "]";
	}
}
