package com.micro.claim.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.Car;
import com.micro.claim.repo.CarRepo;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceImplementationTestCase {

    @Mock
    private CarRepo carRepo;

    @InjectMocks
    private CarServiceImplementation carService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCar() {
        Car car = new Car(1, "Toyota", "Corolla", "Top End", "2022", new Date(), "ABC123");
        carService.addCar(car);
        verify(carRepo, times(1)).save(car);
    }

    @Test
    public void testGetAllCars() {
        Car car1 = new Car(1, "Toyota", "Corolla", "Top End", "2022", new Date(), "ABC123");
        Car car2 = new Car(2, "Honda", "Civic", "Top End", "2023", new Date(), "XYZ789");
        when(carRepo.findAllCars()).thenReturn(Arrays.asList(car1, car2));

        List<Car> cars = carService.getallCars();
        assertNotNull(cars);
        assertEquals(2, cars.size());
        assertEquals("Toyota", cars.get(0).getCar_make());
        assertEquals("Honda", cars.get(1).getCar_make());
    }

    @Test
    public void testDeleteCar() {
        int carId = 1;
        carService.deleteCar(carId);
        verify(carRepo, times(1)).deleteById(carId);
    }

    @Test
    public void testFindCarById() {
        Car car = new Car(1, "Toyota", "Corolla", "Top End", "2022", new Date(), "ABC123");
        when(carRepo.findById(1)).thenReturn(car);

        Car foundCar = carService.findCarById(1);
        assertNotNull(foundCar);
        assertEquals("Toyota", foundCar.getCar_make());
    }

    @Test
    public void testFindCarByName() {
        Car car = new Car(1, "Toyota", "Corolla", "Top End", "2022", new Date(), "ABC123");
        when(carRepo.findByName("Corolla")).thenReturn(car);

        Car foundCar = carService.findCarByName("Corolla");
        assertNotNull(foundCar);
        assertEquals("Toyota", foundCar.getCar_make());
    }
}
