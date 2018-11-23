package com.CarRental.controller;

import com.CarRental.model.Car;
import com.CarRental.model.Rental;
import com.CarRental.model.RentalStatus;
import com.CarRental.model.User;
import com.CarRental.service.IRentalService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin
@RestController
public class RentalController {

    @Autowired
    private IRentalService rentalService;

    @CrossOrigin
    @RequestMapping(value = "/rent/{userId}/{carId}",method = RequestMethod.GET)
    public void rentCar(@PathVariable long userId, @PathVariable long carId) throws Exception{

        rentalService.toRentCar(userId, carId,null,null);
    }

    @CrossOrigin
    @RequestMapping(value = "/takeReservedCar/{userId}/{carId}",method = RequestMethod.GET)
    public void takeReservedCar(@PathVariable long userId, @PathVariable long carId) throws Exception{
        rentalService.takeReservedCar(userId, carId);
    }

    @CrossOrigin
    @RequestMapping(value = "/rent/{userId}/{carId}/{returnDate}",method = RequestMethod.GET)
    public void rentCar(@PathVariable long userId, @PathVariable long carId, @PathVariable String returnDate) throws Exception{

        rentalService.toRentCar(userId, carId,null,LocalDate.parse(returnDate));
    }

    @CrossOrigin
    @RequestMapping(value = "/reserve/{userId}/{carId}/{startingdate}",method = RequestMethod.GET)
    public void reserveCar(@PathVariable long userId, @PathVariable long carId,@PathVariable String startingdate) throws Exception{
        rentalService.toRentCar(userId, carId, LocalDate.parse(startingdate),null);
    }

    @CrossOrigin
    @RequestMapping(value = "/carReturn/{carid}",method = RequestMethod.GET)
    public Car carReturn(@PathVariable long carid) throws Exception{
        return rentalService.returnCar(carid);
    }

    @CrossOrigin
    @RequestMapping(value = "/rent/{userid}",method = RequestMethod.GET)
    public User toCheckCustomer(@PathVariable long userid) throws Exception{
        return rentalService.toCheckCustomer(userid);
    }

    @CrossOrigin
    @RequestMapping(value = "/listofrentcar", method = RequestMethod.GET)
    public List<Car> allRentedCar() throws Exception{
        return  rentalService.findByStatus(RentalStatus.RENTED);
    }

    @CrossOrigin
    @RequestMapping(value = "/listofreservedcar", method = RequestMethod.GET)
    public List<Car> allReservedCar() throws Exception{
        return  rentalService.findByStatus(RentalStatus.RESERVED);
    }

    @CrossOrigin
    @RequestMapping(value = "/listofreturnedcar", method = RequestMethod.GET)
    public List<Car> allReturnedCar() throws Exception{
        return  rentalService.findByStatus(RentalStatus.RETURNED);
    }
}
