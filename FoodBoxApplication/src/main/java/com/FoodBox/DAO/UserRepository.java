package com.FoodBox.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodBox.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
