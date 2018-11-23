package com.CarRental.controller;

import com.CarRental.model.Car;
import com.CarRental.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
public class ReservationController {

    /*@Autowired
    private IReservationService reservationService;

    @RequestMapping(value = "/reserve/{userId}/{carId}",method = RequestMethod.GET)
    public void reserveCar(@PathVariable long userId, @PathVariable long carId, LocalDate startingdate) throws Exception{

        reservationService.toReserveCar(userId, carId, startingdate);
    }

    @RequestMapping(value = "/reservedCarReturn/{carid}",method = RequestMethod.GET)
    public Car carReturn(@PathVariable long carid) throws Exception{
        return reservationService.returnCar(carid);
    }*/
}
