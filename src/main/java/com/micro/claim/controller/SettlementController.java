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

import com.micro.claim.model.Settlement;
import com.micro.claim.service.SettlementServiceImplementation;

@RestController
@RequestMapping("/settlement")
@CrossOrigin(origins = "http://localhost:3000")
public class SettlementController 
{
	SettlementServiceImplementation service;

	public SettlementController(SettlementServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public Settlement insertSettlement(@RequestBody Settlement settlement)
	{
	service.addSettlement(settlement);
	return settlement;
	}

	@GetMapping("/all")
	public List<Settlement> readAllSettlements()
	{
	return service.getallSettlements();
	}

	@PutMapping
	public  String updateSettlement(@RequestBody Settlement settlement)
	{
	String msg = "";
	try {
	service.updateSettlement(settlement);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{settlement_id}")
	public String deleteSettlementbyId(@PathVariable("settlement_id") int settlement_id)
	{
	String msg = "";
	try {
	service.deleteSettlement(settlement_id);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{settlement_id}")
	public Settlement findSettlement(@PathVariable("settlement_id") int settlement_id)
	{
		return service.findSettlementById(settlement_id);
	}	
}
