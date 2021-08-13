package com.Jesus.beltexamreview.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.Jesus.beltexamreview.models.EventUser;
import com.Jesus.beltexamreview.repositories.UserRepository;

@Component
public class UserValidator implements Validator{
	@Autowired
	private UserRepository uRepo;
	
	@Override
    public boolean supports(Class<?> clazz) {
        return EventUser.class.equals(clazz);
    }
	
	@Override
    public void validate(Object target, Errors errors) {
        EventUser user = (EventUser) target;
        
        if(this.uRepo.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Unique","Invalid Email");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match", "Invalid Password");
        }         
    }
}