package com.FoodBox.DAO;

import java.sql.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FoodBox.model.Cuisines;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisines, Integer>{

	

}