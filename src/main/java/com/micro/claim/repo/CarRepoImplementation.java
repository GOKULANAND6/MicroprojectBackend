package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarRepoImplementation implements CarRepo
{
	EntityManager manager;
	
	public CarRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(Car car) 
	{
		manager.persist(car);
	}

	@Override
	public List<Car> findAllCars() 
	{
		String str = "From Car";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(Car car) 
	{
		manager.merge(car);
	}

	@Override
	public void deleteById(int car_id) 
	{
		Car car = manager.find(Car.class, car_id);
		manager.remove(car);
	}

	@Override
	public Car findById(int car_id) 
	{
		return manager.find(Car.class, car_id);
	}

	@Override
	public Car findByName(String car_name) 
	{
		String str = "From Car where car_name=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", car_name);
		return (Car) query.getSingleResult();
	}
}
