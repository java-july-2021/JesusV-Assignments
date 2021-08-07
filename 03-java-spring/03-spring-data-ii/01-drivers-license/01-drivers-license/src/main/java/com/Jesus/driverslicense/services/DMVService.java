package com.Jesus.driverslicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jesus.driverslicense.models.License;
import com.Jesus.driverslicense.models.Person;
import com.Jesus.driverslicense.repositories.LicenseRepository;
import com.Jesus.driverslicense.repositories.PersonRepository;

@Service
public class DMVService {
	@Autowired
	private PersonRepository pRepo;
	@Autowired
	private LicenseRepository lRepo;
		
	public DMVService(PersonRepository pRepo, LicenseRepository lRepo) {
		this.pRepo = pRepo;
		this.lRepo = lRepo;
	}
	
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	public Person getOnePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Person> getAllPeople(){
		return this.pRepo.findAll();
	}
	
	public List<Person> getUnlicensedPeople(){
		return this.pRepo.findByLicenseIdIsNull();
	}
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(license);
	}
	
	public int generateLicenseNumber() {
		License l = this.lRepo.findTopByOrderByNumberDesc();
		if(l == null) {
			return 1;
		}
		int validNumber = l.getNumber();
		validNumber++;
		return (validNumber);
	}
}
