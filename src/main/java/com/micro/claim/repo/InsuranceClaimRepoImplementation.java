package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.InsuranceClaim;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InsuranceClaimRepoImplementation implements InsuranceClaimRepo
{
	EntityManager manager;
	
	public InsuranceClaimRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(InsuranceClaim claim) 
	{
		manager.merge(claim);
	}

	@Override
	public List<InsuranceClaim> findAllInsuranceClaims() 
	{
		String str = "From InsuranceClaim";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(InsuranceClaim claim) 
	{
		manager.merge(claim);
	}

	@Override
	public void deleteById(int claim_id) 
	{
		InsuranceClaim claim = manager.find(InsuranceClaim.class, claim_id);
		manager.remove(claim);
	}

	@Override
	public InsuranceClaim findById(int claim_id) 
	{
		return manager.find(InsuranceClaim.class, claim_id);
	}

	@Override
	public InsuranceClaim findByName(String claim_issue) 
	{
		String str = "From InsuranceClaim where claim_issue=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", claim_issue);
		return (InsuranceClaim) query.getSingleResult();
	}
}
