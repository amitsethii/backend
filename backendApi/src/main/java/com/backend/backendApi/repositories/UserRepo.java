package com.backend.backendApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backendApi.entities.User;


//JPA provide all functionalities
public interface UserRepo extends JpaRepository<User,Integer> {

}
