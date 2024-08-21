package com.micro.claim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.service.InsuranceClaimServiceImplementation;

@RestController
@RequestMapping("/claim")
@CrossOrigin(origins = "http://localhost:3000")
public class InsuranceClaimController 
{
	InsuranceClaimServiceImplementation service;

	public InsuranceClaimController(InsuranceClaimServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public  InsuranceClaim insertClaim(@RequestBody InsuranceClaim claim)
	{
	service.addClaim(claim);
	return claim;
	}

	@GetMapping("/all")
	public List<InsuranceClaim> readAllInsuranceClaims()
	{
	return service.getallInsuranceClaims();
	}

	@PutMapping
	public  String updateClaim(@RequestBody InsuranceClaim claim)
	{
	String msg = "";
	try {
	service.updateClaim(claim);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{claim_id}")
	public String deleteClaimbyId(@PathVariable("claim_id") int claim_id)
	{
	String msg = "";
	try {
	service.deleteClaim(claim_id);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{claim_id}")
	public InsuranceClaim findClaim(@PathVariable("claim_id") int claim_id)
	{
			return service.findClaimById(claim_id);
	}	
}
