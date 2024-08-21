package com.micro.claim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "admindetails")
public class AdminSignup 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int admin_id;
	private String admin_name;
	private String admin_mobile;
	private String admin_password;
	
	public AdminSignup() 
	{
		super();
	}

	public AdminSignup(int admin_id, String admin_name, String admin_mobile, String admin_password) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_mobile = admin_mobile;
		this.admin_password = admin_password;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_mobile() {
		return admin_mobile;
	}

	public void setAdmin_mobile(String admin_mobile) {
		this.admin_mobile = admin_mobile;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	@Override
	public String toString() {
		return "AdminSignup [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_mobile=" + admin_mobile
				+ ", admin_password=" + admin_password + "]";
	}
}
