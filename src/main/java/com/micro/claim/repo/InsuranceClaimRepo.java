package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.InsuranceClaim;

public interface InsuranceClaimRepo 
{
	public void save(InsuranceClaim claim);

	public List<InsuranceClaim> findAllInsuranceClaims();

	public void update(InsuranceClaim claim);

	public void deleteById(int claim_id);
	
	public InsuranceClaim findById(int claim_id);
	
	public InsuranceClaim findByName(String claim_issue);
}
