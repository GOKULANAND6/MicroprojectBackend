package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.CarInsurance;

public interface CarInsuranceRepo 
{
	public void save(CarInsurance carinsurance);

	public List<CarInsurance> findAllCarInsurances();

	public void update(CarInsurance carinsurance);

	public void deleteById(int policy_id);
	
	public CarInsurance findById(int policy_id);
	
	public CarInsurance findByName(String policy_name);
}
