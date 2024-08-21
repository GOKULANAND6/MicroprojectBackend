package com.micro.claim.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "settlement")
public class Settlement 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int settlement_id;
	private int settlement_amount;
	private String settlement_status;
	
	@OneToOne(targetEntity = InsuranceClaim.class, cascade = CascadeType.ALL)
	private InsuranceClaim insuranceclaim;

	public Settlement() 
	{
		super();
	}

	public Settlement(int settlement_id, int settlement_amount, String settlement_status,
			InsuranceClaim insuranceclaim) {
		super();
		this.settlement_id = settlement_id;
		this.settlement_amount = settlement_amount;
		this.settlement_status = settlement_status;
		this.insuranceclaim = insuranceclaim;
	}

	public int getSettlement_id() {
		return settlement_id;
	}

	public void setSettlement_id(int settlement_id) {
		this.settlement_id = settlement_id;
	}

	public int getSettlement_amount() {
		return settlement_amount;
	}

	public void setSettlement_amount(int settlement_amount) {
		this.settlement_amount = settlement_amount;
	}

	public String getSettlement_status() {
		return settlement_status;
	}

	public void setSettlement_status(String settlement_status) {
		this.settlement_status = settlement_status;
	}

	public InsuranceClaim getInsuranceclaim() {
		return insuranceclaim;
	}

	public void setInsuranceclaim(InsuranceClaim insuranceclaim) {
		this.insuranceclaim = insuranceclaim;
	}

	@Override
	public String toString() {
		return "Settlement [settlement_id=" + settlement_id + ", settlement_amount=" + settlement_amount
				+ ", settlement_status=" + settlement_status + ", insuranceclaim=" + insuranceclaim + "]";
	}
}
