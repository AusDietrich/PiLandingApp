package com.dietrich.landing.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class LedEntity {

	private String input;
	private String para;

	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
}
