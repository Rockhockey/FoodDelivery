package com.FoodBox.CustomAnnotations;

import java.util.Objects;

import java.util.*;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.FoodBox.controller.UserController;
import com.FoodBox.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
  
	@Autowired
	private UserController userController;
	
	



@Override
  public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
    if (Objects.nonNull(username) && !username.isEmpty()) {
      if (userController.getUser(username)!=null) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(
          "Username should be unique. '"  + username + "' is already taken").addConstraintViolation();
        return false;
      }
      return true;
    } else {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(
        "Username is required and can't be empty'").addConstraintViolation();
      return false;
    }
  }
}