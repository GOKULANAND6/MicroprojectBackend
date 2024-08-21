package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.AdminSignup;

public interface AdminService 
{
	public void addAdmin(AdminSignup admin);
	 
	public List<AdminSignup> getallAdmins();

	public void updateAdmin(AdminSignup admin);

	public void deleteAdmin(int admin_id);
	
	public AdminSignup findAdminById(int admin_id);
	
	public AdminSignup findAdminByName(String admin_name);
}
