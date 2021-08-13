package com.Jesus.beltexamreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Jesus.beltexamreview.models.EventUser;

@Repository
public interface UserRepository extends CrudRepository<EventUser, Long>{
	List<EventUser> findAll();
	
	EventUser findByEmail(String email);
	
	boolean existsByEmail(String email);
}