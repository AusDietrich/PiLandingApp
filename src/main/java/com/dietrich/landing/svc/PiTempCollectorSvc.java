package com.dietrich.landing.svc;

import java.util.List;

import com.dietrich.landing.entity.DailyTemp;
import com.dietrich.landing.entity.LedEntity;

public interface PiTempCollectorSvc {

	public void fintech();
	
	public List<DailyTemp> getAllData();
	
	public void insertDate(String time, String temp);
}
