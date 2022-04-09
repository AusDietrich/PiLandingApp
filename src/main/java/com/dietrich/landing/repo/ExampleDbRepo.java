package com.dietrich.landing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietrich.landing.entity.firstdb;

@Repository
public interface ExampleDbRepo extends JpaRepository<firstdb, Integer>{
	
}
