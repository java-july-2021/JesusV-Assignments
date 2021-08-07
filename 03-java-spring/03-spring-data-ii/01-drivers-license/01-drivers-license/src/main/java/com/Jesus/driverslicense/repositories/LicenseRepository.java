package com.Jesus.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Jesus.driverslicense.models.License;

public interface LicenseRepository extends CrudRepository <License, Long>{
	List<License> findAll();
	License findTopByOrderByNumberDesc();
}
