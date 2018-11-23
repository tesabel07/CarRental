package com.CarRental.service.Impl;

import com.CarRental.model.Car;
import com.CarRental.model.ERole;
import com.CarRental.model.User;
import com.CarRental.repository.ICarRepository;
import com.CarRental.service.ICarService;
import com.CarRental.service.IUserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private IUserServise userServise;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> allCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> availableCar() {
        return carRepository.findAllByIsAvailable(true);
    }

    @Override
    public Car getCar(long id) {
        return carRepository.getOne(id);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void delete(long userId, long id) throws Exception {
        User user1 = userServise.getUser(userId);
        if (user1.getWho_R_U().equals(ERole.ADMIN)) deleteCar(id);
    }
}
