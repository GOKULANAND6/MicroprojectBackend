package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.CarInsurance;

public interface CarInsuranceService 
{
	public void addCarinsurance(CarInsurance carinsurance);
	 
	public List<CarInsurance> getallCarinsurances();

	public void updateCarinsurance(CarInsurance carinsurance);

	public void deleteCarinsurance(int policy_id);
	
	public CarInsurance findCarinsuranceById(int policy_id);
	
	public CarInsurance findCarinsuranceByName(String policy_name);

}
