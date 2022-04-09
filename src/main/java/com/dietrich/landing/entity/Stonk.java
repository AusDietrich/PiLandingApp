package com.dietrich.landing.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="Stonk")
public class Stonk {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int dayID;
	
	@Column
	public String name;
	@Column
	public String dayTime;
	@Column
	public double price;
	@Column(name="changePoint")
	public double change_point;
	@Column(name="changePercentage")
	public double change_percentage;
	@Column(name="totalVol")
	public String total_vol;
}
