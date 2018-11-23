package com.CarRental.controller;

import com.CarRental.model.User;
import com.CarRental.service.IUserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private IUserServise userServise;

    @CrossOrigin
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public void signUp(@RequestBody User user)throws Exception{
        userServise.signUp(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public User loggedIn(@RequestBody User user)throws Exception{
       // System.out.println(user.getEmail() + user.getPassword() + "hhh----------------------------------hhhhhhh");
       return userServise.loggIn(user);
    }

}
