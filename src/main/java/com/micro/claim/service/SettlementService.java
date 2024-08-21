package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.Settlement;

public interface SettlementService 
{
	public void addSettlement(Settlement settlement);
	 
	public List<Settlement> getallSettlements();

	public void updateSettlement(Settlement settlement);

	public void deleteSettlement(int settlement_id);
	
	public Settlement findSettlementById(int settlement_id);
}
