package com.CarRental.repository;

import com.CarRental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

}
