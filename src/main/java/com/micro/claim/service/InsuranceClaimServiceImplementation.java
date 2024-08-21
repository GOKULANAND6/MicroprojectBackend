package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.repo.InsuranceClaimRepo;

@Service
public class InsuranceClaimServiceImplementation implements InsuranceClaimService
{
	InsuranceClaimRepo repo;
	
	public InsuranceClaimServiceImplementation(InsuranceClaimRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addClaim(InsuranceClaim claim) 
	{
		repo.save(claim);
	}

	@Override
	public List<InsuranceClaim> getallInsuranceClaims() 
	{
		return repo.findAllInsuranceClaims();
	}

	@Override
	public void updateClaim(InsuranceClaim claim) 
	{
		repo.update(claim);
	}

	@Override
	public void deleteClaim(int claim_id) 
	{
		repo.deleteById(claim_id);
	}

	@Override
	public InsuranceClaim findClaimById(int claim_id) 
	{
		return repo.findById(claim_id);
	}

	@Override
	public InsuranceClaim findClaimByName(String claim_issue) 
	{
		return repo.findByName(claim_issue);
	}
}
