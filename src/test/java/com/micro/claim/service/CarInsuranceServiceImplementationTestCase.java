package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.claim.model.CarInsurance;
import com.micro.claim.repo.CarInsuranceRepo;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarInsuranceServiceImplementationTestCase {

    @Mock
    private CarInsuranceRepo repo;

    @InjectMocks
    private CarInsuranceServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCarInsurances() {
        CarInsurance carInsurance1 = new CarInsurance();
        CarInsurance carInsurance2 = new CarInsurance();
        when(repo.findAllCarInsurances()).thenReturn(Arrays.asList(carInsurance1, carInsurance2));

        assertEquals(2, service.getallCarinsurances().size());
    }

    @Test
    void testDeleteCarInsurance() {
        doNothing().when(repo).deleteById(anyInt());

        service.deleteCarinsurance(1);

    }

    @Test
    void testFindCarInsuranceById() {
        CarInsurance carInsurance = new CarInsurance();
        when(repo.findById(anyInt())).thenReturn(carInsurance);

        CarInsurance found = service.findCarinsuranceById(1);

        assertNotNull(found);
    }

    @Test
    void testFindCarInsuranceByName() {
        CarInsurance carInsurance = new CarInsurance();
        when(repo.findByName(any(String.class))).thenReturn(carInsurance);

        CarInsurance found = service.findCarinsuranceByName("Test Policy");

        assertNotNull(found);
    }
}
