package com.CarRental.service;

import com.CarRental.model.Car;
import com.CarRental.model.User;

import java.time.LocalDate;

public interface IReservationService {

    void toReserveCar(long userId, long carId, LocalDate startingdate) throws Exception;
    User toCheckCustomer(long userid) throws Exception;
    Car returnCar(long carid) throws Exception;
}
