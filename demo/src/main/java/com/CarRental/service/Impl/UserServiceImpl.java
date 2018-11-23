package com.CarRental.service.Impl;

import com.CarRental.model.Address;
import com.CarRental.model.User;
import com.CarRental.repository.AddressRepository;
import com.CarRental.repository.IUserRepository;
import com.CarRental.service.IUserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserServise {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void signUp(User user) throws Exception{
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new Exception("the user name is already exist");
        }
        System.out.println(user.getFirstName());
        Address address= addressRepository.saveAndFlush(user.getAddress());
        user.setAddress(address);
        userRepository.save(user);
    }

    @Override
    public User loggIn(User user) throws Exception{
        User temp = userRepository.findByEmail(user.getEmail());
        if(!temp.getPassword().equals(user.getPassword())){
            throw new Exception("password is not correct");
        }
        return temp;
    }

    @Override
    public User getUser(long userId) throws Exception {
        User user = userRepository.getOne(userId);
        if(user == null) {
            throw new Exception("Can not find the specified user.");
        }
        return user;
    }
}
