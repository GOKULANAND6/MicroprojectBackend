package com.micro.claim.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.repo.InsuranceClaimRepo;

public class InsuranceClaimServiceImplementationTestCase {

    @Mock
    private InsuranceClaimRepo repo;

    @InjectMocks
    private InsuranceClaimServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddClaim() {
        InsuranceClaim claim = new InsuranceClaim();
        service.addClaim(claim);
        verify(repo).save(claim);
    }

    @Test
    public void testGetAllInsuranceClaims() {
        List<InsuranceClaim> claims = new ArrayList<>();
        claims.add(new InsuranceClaim());

        doReturn(claims).when(repo).findAllInsuranceClaims();

        List<InsuranceClaim> result = service.getallInsuranceClaims();
        assertEquals(claims, result);
    }

    @Test
    public void testDeleteClaim() {
        int claimId = 1;
        doNothing().when(repo).deleteById(claimId);

        service.deleteClaim(claimId);
        verify(repo).deleteById(claimId);
    }

    @Test
    public void testFindClaimById() {
        int claimId = 1;
        InsuranceClaim claim = new InsuranceClaim();
        doReturn(claim).when(repo).findById(claimId);

        InsuranceClaim result = service.findClaimById(claimId);
        assertEquals(claim, result);
    }

    @Test
    public void testFindClaimByName() {
        String claimIssue = "Engine Failure";
        InsuranceClaim claim = new InsuranceClaim();
        doReturn(claim).when(repo).findByName(claimIssue);

        InsuranceClaim result = service.findClaimByName(claimIssue);
        assertEquals(claim, result);
    }
}
