package com.Jesus.beltexamreview.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jesus.beltexamreview.models.EventUser;
import com.Jesus.beltexamreview.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public EventUser findById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public List<EventUser> getAllUsers(){
		return this.uRepo.findAll();
	}
	
	public boolean emailExist(String email) {
		return this.uRepo.existsByEmail(email);
	}
	
	public void saveEventUser(EventUser user) {
		this.uRepo.save(user);
	}
	
	public EventUser registerUser(EventUser user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
	
	public EventUser getUserByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	public boolean authenticateUser(String email, String password) {
		EventUser user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())){
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void deleteUser(EventUser user) {
		this.uRepo.delete(user);
	}
}