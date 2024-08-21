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

import com.micro.claim.model.Car;
import com.micro.claim.service.CarServiceImplementation;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController 
{
	CarServiceImplementation service;
	
	public CarController(CarServiceImplementation service) {
		super();
		this.service = service;
	}

	@PostMapping
	public  String insertCar(@RequestBody Car car)
	{
	String msg = "";
	try {
	service.addCar(car);
	msg = "Successfully Added";
	}
	catch (Exception e) {
	msg = "Failed to Add";
	}
	return msg;
	}

	@GetMapping("/all")
	public List<Car> readAllCars()
	{
	return service.getallCars();
	}

	@PutMapping
	public  String updateCar(@RequestBody Car car)
	{
	String msg = "";
	try {
	service.updateCar(car);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{car_id}")
	public String deleteCarbyId(@PathVariable("car_id") int car_id)
	{
	String msg = "";
	try {
	service.deleteCar(car_id);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{car_id}")
	public Car findCar(@PathVariable("car_id") int car_id)
	{
			return service.findCarById(car_id);
	}	
}
