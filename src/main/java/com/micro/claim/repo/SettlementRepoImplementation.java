package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.Settlement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SettlementRepoImplementation implements SettlementRepo
{
	EntityManager manager;
	
	public SettlementRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(Settlement settlement) 
	{
		manager.merge(settlement);
	}

	@Override
	public List<Settlement> findAllSettlements() 
	{
		String str = "From Settlement";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(Settlement settlement) 
	{
		manager.merge(settlement);
	}

	@Override
	public void deleteById(int settlement_id) 
	{
		Settlement settlement = manager.find(Settlement.class, settlement_id);
	}

	@Override
	public Settlement findById(int settlement_id) 
	{
		return manager.find(Settlement.class, settlement_id);
	}
}
