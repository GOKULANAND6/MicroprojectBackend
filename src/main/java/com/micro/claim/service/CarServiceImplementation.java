package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.Car;
import com.micro.claim.repo.CarRepo;

@Service
public class CarServiceImplementation implements CarService
{
	CarRepo repo;
	
	public CarServiceImplementation(CarRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addCar(Car car) 
	{
		repo.save(car);
	}

	@Override
	public List<Car> getallCars() 
	{
		return repo.findAllCars();
	}

	@Override
	public void updateCar(Car car) 
	{
		repo.update(car);
	}

	@Override
	public void deleteCar(int car_id) 
	{
		repo.deleteById(car_id);
	}

	@Override
	public Car findCarById(int car_id) 
	{
		return repo.findById(car_id);
	}

	@Override
	public Car findCarByName(String car_name) 
	{
		return repo.findByName(car_name);
	}
}
