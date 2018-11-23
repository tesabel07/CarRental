package com.CarRental.service;

import com.CarRental.model.User;

public interface IUserServise {
    void signUp(User user)throws Exception;
    User loggIn(User user)throws Exception;
    User getUser(long userId)throws Exception;
}
