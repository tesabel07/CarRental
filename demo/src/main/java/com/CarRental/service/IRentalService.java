package com.CarRental.service;

import com.CarRental.model.Car;
import com.CarRental.model.Rental;
import com.CarRental.model.RentalStatus;
import com.CarRental.model.User;

import java.time.LocalDate;
import java.util.List;

public interface IRentalService {
    void toRentCar(long userId, long carId,LocalDate startingdate,LocalDate returnDate) throws Exception;
    void takeReservedCar(long userId, long carId) throws Exception;
    User toCheckCustomer(long userid) throws Exception;
    Car returnCar(long carid) throws Exception;
    List<Car> findByStatus(RentalStatus status) throws Exception;

}
