package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.AdminSignup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepoImplementation implements AdminRepo
{
	EntityManager manager;
	
	public AdminRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(AdminSignup admin) 
	{
		manager.persist(admin);
	}

	@Override
	public List<AdminSignup> findAllAdminSignups() 
	{
		String str = "From AdminSignup";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(AdminSignup admin) 
	{
		manager.merge(admin);
	}

	@Override
	public void deleteById(int admin_id) 
	{
		AdminSignup admin = manager.find(AdminSignup.class, admin_id);
		manager.remove(admin);
	}

	@Override
	public AdminSignup findById(int admin_id) 
	{
		return manager.find(AdminSignup.class, admin_id);
	}

	@Override
	public AdminSignup findByName(String admin_name) 
	{
		String str = "From AdminSignup where admin_name=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", admin_name);
		return (AdminSignup) query.getSingleResult();
	}
}
