package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.CustomerSignup;

public interface CustomerRepo 
{
	public void save(CustomerSignup customer);

	public List<CustomerSignup> findAllCustomerSignups();

	public void update(CustomerSignup customer);

	public void deleteById(int customer_id);
	
	public CustomerSignup findById(int customer_id);
	
	public CustomerSignup findByName(String customer_name);
}
