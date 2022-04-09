package com.dietrich.landing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class DailyTemp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int dayID;
	
	@Column
	public String doubleO;
	@Column
	public String six;
	@Column
	public String noon;
	@Column
	public String eighteen;
}
