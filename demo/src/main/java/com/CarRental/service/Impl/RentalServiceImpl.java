package com.CarRental.service.Impl;

import com.CarRental.model.Car;
import com.CarRental.model.Rental;
import com.CarRental.model.RentalStatus;
import com.CarRental.model.User;
import com.CarRental.repository.ICarRepository;
import com.CarRental.repository.IRentalRepository;
import com.CarRental.repository.IUserRepository;
import com.CarRental.service.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RentalServiceImpl implements IRentalService {


    @Autowired
    private IRentalRepository rentalRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICarRepository carRepository;

    @Override
    public void toRentCar(long userId, long carId, LocalDate startingdate, LocalDate returnDate) throws Exception {
        User user = userRepository.getOne(userId);                     //call from user database
        if (user == null) {
            throw new Exception("the user is not return, create account");
        }
        Car car = carRepository.getOne(carId);                         //call from car database
        if (car == null) {
            throw new Exception("the car already rented");
        }
        if (!car.isAvailable()) {
            throw new Exception("The car is already been rent out.");
        }
        Rental reservedCar= rentalRepository.findByCarAndUserAndStatus(car,user,RentalStatus.RESERVED);
        Rental rental = new Rental();                                      //new rental object
        rental.setUser(user);
        rental.setCar(car);
        if(reservedCar != null){
            if(returnDate.isAfter(reservedCar.getStartingdate())) throw new Exception("The return date can not exid from "+ reservedCar.getStartingdate());
            rental.setEndday(returnDate);
        }
        if(startingdate == null) {
            rental.setStartingdate(LocalDate.now());
            rental.setStatus(RentalStatus.RENTED);
            car.setAvailable(false);
        }else {
            rental.setStartingdate(startingdate);
            rental.setStatus(RentalStatus.RESERVED);
        }
        rentalRepository.save(rental);                                   //save rental in to rental database

    }

    @Override
    public void takeReservedCar(long userId, long carId) throws Exception {
        User user = userRepository.getOne(userId);                     //call from user database
        if (user == null) {
            throw new Exception("the user is not return, create account");
        }
        Car car = carRepository.getOne(carId);                         //call from car database
        if (car == null) {
            throw new Exception("the car already rented");
        }
        Rental reservedCar= rentalRepository.findByCarAndUserAndStatus(car,user,RentalStatus.RESERVED);
        Rental rentedCar= rentalRepository.findByCarAndUserAndStatus(car,user,RentalStatus.RENTED);
        if(reservedCar == null && rentedCar != null){
            throw new Exception("there car is no reserved or not Returend yet ");
        }
        reservedCar.setStatus(RentalStatus.RENTED);
        car.setAvailable(false);
        rentalRepository.save(reservedCar);
    }

    @Override
    public User toCheckCustomer(long userid) throws Exception {
        User customer = userRepository.getOne(userid);
        if (customer == null) {
            throw new Exception("create account");
        }
        Rental rental = rentalRepository.findFirstByUserAndEnddayIsNull(customer);
        if (rental == null) {
            throw new Exception("the customer is free");
        } else {
            return customer;
        }
    }

    @Override
    public Car returnCar(long carid) throws Exception {
        Car returnedCar = carRepository.getOne(carid);                    //call from cat database
        if (returnedCar == null) {
            throw new Exception("the car is not rented or it is not available");
        } else {
            Rental rental = rentalRepository.findFirstByCarAndEnddayIsNull(returnedCar);   //call from rental from rental database and end date will be null
            if (rental == null) {
                throw new Exception("the car is not rented");
            }
            rental.setEndday(LocalDate.now());                             //to return set last day of renting date
            rental.setStatus(RentalStatus.RETURNED);                        // change the status to returned
            returnedCar.setAvailable(true);                                 //and set availablity to true
    }
        return returnedCar;
    }

    @Override
    public List<Car> findByStatus(RentalStatus status) throws Exception {
        List<Rental> rentalList = rentalRepository.findByStatus(status);
        List<Car> carList = new ArrayList<>();

        if (rentalList == null){
            throw new Exception("there is no rented car");
        }
        for (Rental r: rentalList){
            carList.add(r.getCar());
        }
        return carList;
    }

}
