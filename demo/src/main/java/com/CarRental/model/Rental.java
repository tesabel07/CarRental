package com.CarRental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rental")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rental {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private User user;
    @OneToOne
    private Car car;
    private LocalDate startingdate;
    private LocalDate endday;
    private RentalStatus status;

    public Rental(){}

    public Rental(User user, Car car,LocalDate startingdate, LocalDate endday, RentalStatus status) {
        this.user = user;
        this.car = car;
        this.startingdate=startingdate;
        this.endday = endday;
        this.status=status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(LocalDate startingdate) {
        this.startingdate = startingdate;
    }

    public LocalDate getEndday() {
        return endday;
    }

    public void setEndday(LocalDate endday) {
        this.endday = endday;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public RentalStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", startingdate=" + startingdate +
                ", endday=" + endday +
                '}';
    }
}
