package com.CarRental.repository;

import com.CarRental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByIsAvailable(boolean availableity);
}
