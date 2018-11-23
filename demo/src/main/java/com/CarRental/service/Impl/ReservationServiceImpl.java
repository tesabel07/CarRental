//package com.CarRental.service.Impl;
//
//import com.CarRental.model.*;
//import com.CarRental.repository.ICarRepository;
//import com.CarRental.repository.IReservationRepository;
//import com.CarRental.repository.IUserRepository;
//import com.CarRental.service.IReservationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.time.LocalDate;
//
//@Service
//@Transactional
//public class ReservationServiceImpl implements IReservationService {
//
//    @Autowired
//    private IUserRepository userRepository;
//    @Autowired
//    private ICarRepository carRepository;
//    @Autowired
//    private IReservationRepository reservationRepository;
//
//
//    @Override
//    public void toReserveCar(long userId, long carId, LocalDate startingdate) throws Exception {
//        User user = userRepository.getOne(userId);                     //call from user database
//        if(user == null){
//            throw new Exception("the user is not return, create account");
//        }
//        Car car = carRepository.getOne(carId);                         //call from car database
//        if(car == null){
//            throw new Exception("the car already rented");
//        }
//        if(!car.isAvailable()) {
//            throw new Exception("The car is already been rent out.");
//        }
//        Rental rental= new Rental();
//        rental.setUser(user);
//        rental.setCar(car);
//        rental.setStatus(RentalStatus.RESERVED);
//        rental.setStartingdate(startingdate);
//
//
//       /* Reservation reservation=new Reservation();                                      //new reservation object
//        reservation.setStartingdate(startingdate);
//        reservation.setUser(user);
//        reservation.setCar(car);
//        reservationRepository.save(reservation);                                   //save reservation in to reservation database
//        */car.setAvailable(false);
//    }
//
//    @Override
//    public User toCheckCustomer(long userid) throws Exception {
//        return null;
//    }
//
//    @Override
//    public Car returnCar(long carid) throws Exception {
//        Car returned = carRepository.getOne(carid);                    //call from cat database
//        if (returned == null) {
//            throw new Exception("the car is not rented or it is not available");
//        } else {
//            Reservation rental = reservationRepository.findFirstByCarAndEnddayIsNull(returned);   //call from rental from rental database and end date will be null
//            if (rental == null) {
//                throw new Exception("the car is not rented");
//            }
//            rental.setEndday(LocalDate.now());                             //to return set last day of renting date
//            returned.setAvailable(true);                                 //and set availablity to true
//        }
//        return returned;
//    }
//}
