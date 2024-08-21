package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.CustomerSignup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImplementation implements CustomerRepo
{
	EntityManager manager;

	public CustomerRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(CustomerSignup customer) 
	{
		manager.persist(customer);
	}

	@Override
	public List<CustomerSignup> findAllCustomerSignups() 
	{
		String str = "From CustomerSignup";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(CustomerSignup customer) 
	{
		manager.merge(customer);
	}

	@Override
	public void deleteById(int customer_id) 
	{
		CustomerSignup customer = manager.find(CustomerSignup.class, customer_id);
		manager.remove(customer);
	}

	@Override
	public CustomerSignup findById(int customer_id) 
	{
		return manager.find(CustomerSignup.class, customer_id);
	}

	@Override
	public CustomerSignup findByName(String customer_name) 
	{
		String str = "From CustomerSignup where customer_name=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", customer_name);
		return (CustomerSignup) query.getSingleResult();
	}
}
