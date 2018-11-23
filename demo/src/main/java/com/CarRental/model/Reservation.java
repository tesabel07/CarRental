//package com.CarRental.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//public class Reservation {
//
//    @Id
//    @GeneratedValue
//    private long id;
//    @OneToOne
//    private User user;
//    @OneToOne
//    private Car car;
//    private LocalDate startingdate;
//    private LocalDate endday;
//
//    public Reservation(){}
//
//    public Reservation(User user, Car car, LocalDate startingdate) {
//        this.user = user;
//        this.car = car;
//        this.startingdate = startingdate;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public LocalDate getStartingdate() {
//        return startingdate;
//    }
//
//    public void setStartingdate(LocalDate startingdate) {
//        this.startingdate = startingdate;
//    }
//
//    public LocalDate getEndday() {
//        return endday;
//    }
//
//    public void setEndday(LocalDate endday) {
//        this.endday = endday;
//    }
//
//    @Override
//    public String toString() {
//        return "Reservation{" +
//                "id=" + id +
//                ", user=" + user +
//                ", car=" + car +
//                ", startingdate=" + startingdate +
//                ", endday=" + endday +
//                '}';
//    }
//}
