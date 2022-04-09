package com.dietrich.landing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@ToString
@Getter
@Setter
@Entity
public class firstdb {

	@Id
	private String id;
}
