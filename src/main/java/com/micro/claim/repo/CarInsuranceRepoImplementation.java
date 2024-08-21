package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.CarInsurance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarInsuranceRepoImplementation implements CarInsuranceRepo
{
	EntityManager manager;

	public CarInsuranceRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(CarInsurance carinsurance) 
	{
		manager.persist(carinsurance);
	}

	@Override
	public List<CarInsurance> findAllCarInsurances() 
	{
		String str = "From CarInsurance";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(CarInsurance carinsurance) 
	{
		manager.merge(carinsurance);
	}

	@Override
	public void deleteById(int policy_id) 
	{
		CarInsurance carinsurance = manager.find(CarInsurance.class, policy_id);
		manager.remove(carinsurance);
	}

	@Override
	public CarInsurance findById(int policy_id) 
	{
		return manager.find(CarInsurance.class, policy_id);
	}

	@Override
	public CarInsurance findByName(String policy_name) 
	{
		String str = "From CarInsurance where policy_name=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", policy_name);
		return (CarInsurance) query.getSingleResult();
	}
}
