package com.CarRental.service;

import com.CarRental.model.Car;
import com.CarRental.model.User;

import java.util.List;

public interface ICarService {
    Car create(Car car);
    List<Car> allCars();
    List<Car> availableCar();
    Car getCar(long id);
    void deleteCar(long id);
    void delete(long userId, long id) throws Exception;
}
