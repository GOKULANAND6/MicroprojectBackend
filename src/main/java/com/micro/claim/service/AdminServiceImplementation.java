package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.AdminSignup;
import com.micro.claim.repo.AdminRepo;

@Service
public class AdminServiceImplementation implements AdminService
{
	AdminRepo repo;

	public AdminServiceImplementation(AdminRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addAdmin(AdminSignup admin) 
	{
		repo.save(admin);
	}

	@Override
	public List<AdminSignup> getallAdmins() 
	{
		return repo.findAllAdminSignups();
	}

	@Override
	public void updateAdmin(AdminSignup admin) 
	{
		repo.update(admin);
	}

	@Override
	public void deleteAdmin(int admin_id) 
	{
		repo.deleteById(admin_id);
	}

	@Override
	public AdminSignup findAdminById(int admin_id) 
	{
		return repo.findById(admin_id);
	}

	@Override
	public AdminSignup findAdminByName(String admin_name) 
	{
		return repo.findByName(admin_name);
	}
}
