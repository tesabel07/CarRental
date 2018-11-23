package com.CarRental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Email(message = "please provide email")
    private String email;
    @NotEmpty(message = "please provide password")
    private String password;
    @NotEmpty(message = "please provide first name")
    private String firstName;
    @NotEmpty(message = "please provade last name")
    private String lastName;
    @Column(name = "dateOfBirth")
    private LocalDate dob;
    private String gender;
    private ERole who_R_U;

    //@NotNull(message = "Address can't be null ")
    @OneToOne
    private Address address;


    public User(){}

    public User(@Email(message = "please provide email") String email, @NotEmpty(message = "please provide password") String passWord, @NotEmpty(message = "please provide first name") String firstName, @NotEmpty(message = "please provade last name") String lastName, LocalDate dob, String gender, ERole who_R_U, Address address) {

        this.email = email;
        this.password = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.who_R_U = who_R_U;
        this.address=address;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ERole getWho_R_U() {
        return who_R_U;
    }

    public void setWho_R_U(ERole who_R_U) {
        this.who_R_U = who_R_U;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
