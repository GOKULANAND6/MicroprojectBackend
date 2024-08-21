package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.InsuranceClaim;

public interface InsuranceClaimService 
{
	public void addClaim(InsuranceClaim claim);
	 
	public List<InsuranceClaim> getallInsuranceClaims();

	public void updateClaim(InsuranceClaim claim);

	public void deleteClaim(int claim_id);
	
	public InsuranceClaim findClaimById(int claim_id);
	
	public InsuranceClaim findClaimByName(String claim_issue);
}
