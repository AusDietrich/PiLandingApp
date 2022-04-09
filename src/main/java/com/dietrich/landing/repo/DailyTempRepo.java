package com.dietrich.landing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietrich.landing.entity.DailyTemp;

@Repository
public interface DailyTempRepo extends JpaRepository<DailyTemp, Integer>{

}
