package com.Jesus.beltexam.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.Jesus.beltexam.models.User;
import com.Jesus.beltexam.repositories.UserRepository;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserRepository uRepo;
	
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if(this.uRepo.existsByEmail(user.getEmail())) {
        	errors.rejectValue("email", "Unique", "The email address is already in use");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match", "Passwords do not match");
        }         
    }
}