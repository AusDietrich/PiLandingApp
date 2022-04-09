package com.dietrich.landing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietrich.landing.entity.Stonk;

@Repository
public interface StonkRepo extends JpaRepository<Stonk, Integer>{

}
