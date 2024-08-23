package com.micro.claim.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.AdminSignup;
import com.micro.claim.repo.AdminRepo;

class AdminServiceImplementationTestCase {

    @Mock
    private AdminRepo repo;

    @InjectMocks
    private AdminServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAdmin() {
        AdminSignup admin = new AdminSignup(1, "Gokul", "1234567890", "password123");
        doNothing().when(repo).save(admin);

        service.addAdmin(admin);

        verify(repo).save(admin);
    }

    @Test
    void testGetAllAdmins() {
        AdminSignup admin1 = new AdminSignup(1, "Gokul", "1234567890", "password123");
        AdminSignup admin2 = new AdminSignup(2, "Jane Doe", "0987654321", "password321");
        List<AdminSignup> admins = Arrays.asList(admin1, admin2);
        when(repo.findAllAdminSignups()).thenReturn(admins);

        List<AdminSignup> result = service.getallAdmins();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(admin1));
        assertTrue(result.contains(admin2));
        verify(repo).findAllAdminSignups();
    }

    @Test
    void testDeleteAdmin() {
        int adminId = 1;
        doNothing().when(repo).deleteById(adminId);

        service.deleteAdmin(adminId);

        verify(repo).deleteById(adminId);
    }

    @Test
    void testFindAdminById() {
        AdminSignup admin = new AdminSignup(1, "Gokul", "1234567890", "password123");
        when(repo.findById(1)).thenReturn(admin);

        AdminSignup result = service.findAdminById(1);

        assertNotNull(result);
        assertEquals(admin.getAdmin_id(), result.getAdmin_id());
        assertEquals(admin.getAdmin_name(), result.getAdmin_name());
        assertEquals(admin.getAdmin_mobile(), result.getAdmin_mobile());
        assertEquals(admin.getAdmin_password(), result.getAdmin_password());
        verify(repo).findById(1);
    }

    @Test
    void testFindAdminByName() {
        AdminSignup admin = new AdminSignup(1, "Gokul", "1234567890", "password123");
        when(repo.findByName("Gokul")).thenReturn(admin);

        AdminSignup result = service.findAdminByName("Gokul");

        assertNotNull(result);
        assertEquals(admin.getAdmin_name(), result.getAdmin_name());
        assertEquals(admin.getAdmin_mobile(), result.getAdmin_mobile());
        assertEquals(admin.getAdmin_password(), result.getAdmin_password());
        verify(repo).findByName("Gokul");
    }
}
