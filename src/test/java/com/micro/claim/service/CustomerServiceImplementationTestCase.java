package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.CustomerSignup;
import com.micro.claim.repo.CustomerRepo;

public class CustomerServiceImplementationTestCase {

    @Mock
    private CustomerRepo repo;

    @InjectMocks
    private CustomerServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCustomer() {
        CustomerSignup customer = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890", "123 Street", "123456", new Date(), "30", "Male", "123");

        service.addCustomer(customer);

        verify(repo).save(customer);
    }

    @Test
    public void testGetAllCustomers() {
        List<CustomerSignup> customers = new ArrayList<>();
        customers.add(new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890", "123 Street", "123456", new Date(), "30", "Male", "123"));

        when(repo.findAllCustomerSignups()).thenReturn(customers);

        List<CustomerSignup> result = service.getallCustomers();
        assertEquals(1, result.size());
        assertEquals("Gokul", result.get(0).getCustomer_name());
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;

        service.deleteCustomer(customerId);

        verify(repo).deleteById(customerId);
    }

    @Test
    public void testFindCustomerById() {
        CustomerSignup customer = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890", "123 Street", "123456", new Date(), "30", "Male", "123");

        when(repo.findById(anyInt())).thenReturn(customer);

        CustomerSignup result = service.findCustomerById(1);
        assertEquals("Gokul", result.getCustomer_name());
    }

    @Test
    public void testFindCustomerByName() {
        CustomerSignup customer = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890", "123 Street", "123456", new Date(), "30", "Male", "123");

        when(repo.findByName(anyString())).thenReturn(customer);

        CustomerSignup result = service.findCustomerByName("Gokul");
        assertEquals("Gokul", result.getCustomer_name());
    }
}
