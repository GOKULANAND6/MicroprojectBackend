package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.CustomerSignup;

public interface CustomerService 
{
	public void addCustomer(CustomerSignup customer);
	 
	public List<CustomerSignup> getallCustomers();

	public void updateCustomer(CustomerSignup customer);

	public void deleteCustomer(int customer_id);
	
	public CustomerSignup findCustomerById(int customer_id);
	
	public CustomerSignup findCustomerByName(String customer_name);
}
