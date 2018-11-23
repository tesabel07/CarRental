package com.CarRental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity

@Table(name = "car")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
    @Id
    @Column(name = "carId")
    @GeneratedValue
   private long carId;
    @Column(name = "brandName")
    @NotEmpty(message = "please provide brandName")
   private String brandName;
    @Column(name = "make")
    @NotEmpty(message = "please provide make")
   private String make;
    @Column(name = "year")
   private int year;
    @Column(name = "rentalPrice")
    private double rentalPrice;
    private boolean isAvailable = true;
    private String pictureLocation;

    public Car(@NotEmpty(message = "please provide brandName") String brandName, @NotEmpty(message = "please provide make") String make, @NotEmpty(message = "please provide year") int year, @NotEmpty(message = "please provide price of the car") double rentalPrice, String pictureLocation) {
        this.brandName = brandName;
        this.make = make;
        this.year = year;
        this.rentalPrice = rentalPrice;
        this.pictureLocation = pictureLocation;
    }

    public Car(){}

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getPictureLocation() {
        return pictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brandName='" + brandName + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", rentalPrice=" + rentalPrice +
                ", isAvailable=" + isAvailable +
                ", pictureLocation='" + pictureLocation + '\'' +
                '}';
    }
}
