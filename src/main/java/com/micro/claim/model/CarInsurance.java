package com.micro.claim.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "carinsurance")
public class CarInsurance 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int policy_id;
	private String policy_name;
	private int policy_scheme;
	private String car_make;
	private String car_name;
	private String car_model;
	private String car_year;
	private String car_buyingdate;
	private String car_number;
	private int policy_amount;
	
	@ManyToOne(targetEntity = CustomerSignup.class, cascade = CascadeType.MERGE)
	@JoinColumn( name = "customer_id")
	private CustomerSignup customer;

	public CarInsurance() 
	{
		super();
	}

	public CarInsurance(int policy_id, String policy_name, int policy_scheme, String car_make, String car_name,
			String car_model, String car_year, String car_buyingdate, String car_number, int policy_amount,
			CustomerSignup customer) {
		super();
		this.policy_id = policy_id;
		this.policy_name = policy_name;
		this.policy_scheme = policy_scheme;
		this.car_make = car_make;
		this.car_name = car_name;
		this.car_model = car_model;
		this.car_year = car_year;
		this.car_buyingdate = car_buyingdate;
		this.car_number = car_number;
		this.policy_amount = policy_amount;
		this.customer = customer;
	}

	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public int getPolicy_scheme() {
		return policy_scheme;
	}

	public void setPolicy_scheme(int policy_scheme) {
		this.policy_scheme = policy_scheme;
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

	public CustomerSignup getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerSignup customer) {
		this.customer = customer;
	}

	public int getPolicy_amount() {
		return policy_amount;
	}

	public void setPolicy_amount(int policy_amount) {
		this.policy_amount = policy_amount;
	}

	@Override
	public String toString() {
		return "CarInsurance [policy_id=" + policy_id + ", policy_name=" + policy_name + ", policy_scheme="
				+ policy_scheme + ", car_make=" + car_make + ", car_name=" + car_name + ", car_model=" + car_model
				+ ", car_year=" + car_year + ", car_buyingdate=" + car_buyingdate + ", car_number=" + car_number
				+ ", policy_amount=" + policy_amount + ", customer=" + customer + "]";
	}
}
