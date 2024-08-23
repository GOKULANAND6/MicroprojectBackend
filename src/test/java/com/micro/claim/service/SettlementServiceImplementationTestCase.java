package com.micro.claim.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.model.Settlement;
import com.micro.claim.repo.SettlementRepo;

@ExtendWith(MockitoExtension.class)
public class SettlementServiceImplementationTestCase {

    @Mock
    private SettlementRepo repo;

    @InjectMocks
    private SettlementServiceImplementation service;

    private Settlement settlement;

    @BeforeEach
    public void setUp() {
        settlement = new Settlement(1, 100000, "Credited", new InsuranceClaim());
    }

    @Test
    public void testAddSettlement() {
        service.addSettlement(settlement);
        verify(repo, times(1)).save(settlement);
    }

    @Test
    public void testGetAllSettlements() {
        when(repo.findAllSettlements()).thenReturn(Arrays.asList(settlement));

        List<Settlement> settlements = service.getallSettlements();
        assertEquals(1, settlements.size());
        assertEquals(settlement, settlements.get(0));
    }

    @Test
    public void testDeleteSettlement() {
        doNothing().when(repo).deleteById(anyInt());

        service.deleteSettlement(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    public void testFindSettlementById() {
        when(repo.findById(anyInt())).thenReturn(settlement);

        Settlement foundSettlement = service.findSettlementById(1);
        assertNotNull(foundSettlement);
        assertEquals(settlement, foundSettlement);
    }
}
