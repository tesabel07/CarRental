package com.CarRental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;

    @Column(name = "street")
    @NotEmpty(message = "please provide the street")
    private String street;
    @Column(name = "city")
    @NotEmpty(message = "please provide the city")
    private String city;
    @Column(name = "state")
    @NotEmpty(message = "please provide the state")
    private String state;
    @Column(name = "zip")
    @NotEmpty(message = "please provide the zip")
    private String zip;

    public Address(@NotEmpty(message = "please provide the street") String street, @NotEmpty(message = "please provide the city") String city, @NotEmpty(message = "please provide the state") String state, @NotEmpty(message = "please provide the zip") String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    public Address(){}

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
