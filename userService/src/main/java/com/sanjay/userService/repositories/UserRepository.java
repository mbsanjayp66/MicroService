package com.sanjay.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjay.userService.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
