package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.AdminSignup;

public interface AdminRepo 
{
	public void save(AdminSignup admin);

	public List<AdminSignup> findAllAdminSignups();

	public void update(AdminSignup admin);

	public void deleteById(int admin_id);
	
	public AdminSignup findById(int admin_id);
	
	public AdminSignup findByName(String admin_name);
}
