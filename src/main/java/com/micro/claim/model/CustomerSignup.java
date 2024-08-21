package com.micro.claim.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "customerdetails")
public class CustomerSignup 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String customer_email;
	private String customer_mobile;
	private String customer_address;
	private String customer_pincode;
	private Date customer_dob;
	private String customer_age;
	private String customer_gender;
	private String customer_password;

	
	public CustomerSignup() 
	{
		super();
	}

	public CustomerSignup(int customer_id, String customer_name, String customer_email, String customer_mobile,
			String customer_address, String customer_pincode, Date customer_dob, String customer_age,
			String customer_gender, String customer_password) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_mobile = customer_mobile;
		this.customer_address = customer_address;
		this.customer_pincode = customer_pincode;
		this.customer_dob = customer_dob;
		this.customer_age = customer_age;
		this.customer_gender = customer_gender;
		this.customer_password = customer_password;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_mobile() {
		return customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_pincode() {
		return customer_pincode;
	}

	public void setCustomer_pincode(String customer_pincode) {
		this.customer_pincode = customer_pincode;
	}

	public Date getCustomer_dob() {
		return customer_dob;
	}

	public void setCustomer_dob(Date customer_dob) {
		this.customer_dob = customer_dob;
	}
	

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	
	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(String customer_age) {
		this.customer_age = customer_age;
	}

	public String getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}

	@Override
	public String toString() {
		return "CustomerSignup [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email="
				+ customer_email + ", customer_mobile=" + customer_mobile + ", customer_address=" + customer_address
				+ ", customer_pincode=" + customer_pincode + ", customer_dob=" + customer_dob + ", customer_age="
				+ customer_age + ", customer_gender=" + customer_gender + ", customer_password=" + customer_password
				+ "]";
	}
}
