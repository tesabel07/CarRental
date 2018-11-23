package com.CarRental.repository;

import com.CarRental.model.Car;
import com.CarRental.model.Rental;
import com.CarRental.model.RentalStatus;
import com.CarRental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentalRepository extends JpaRepository<Rental,Long> {
 Rental findFirstByCarAndEnddayIsNull(Car car);
 Rental findFirstByUserAndEnddayIsNull(User user);
 List<Rental> findFirstByAndEnddayIsNull();
 List<Rental> findByStatus(RentalStatus rentalStatus);
 Rental findByCarAndUserAndStatus(Car car, User user, RentalStatus status);
}
