package com.dietrich.landing.svc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dietrich.landing.entity.DailyTemp;
import com.dietrich.landing.entity.LedEntity;
import com.dietrich.landing.entity.Stonk;
import com.dietrich.landing.repo.DailyTempRepo;
import com.dietrich.landing.repo.StonkRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

@Service
public class PiTempCollectorSvcImpl implements PiTempCollectorSvc {

	@Autowired
	DailyTempRepo tempRepo;
	@Autowired
	StonkRepo stonkRepo;
	
	@Value("${apiHost}")
	private String host;
	@Value("${apiKey}")
	private String key;
	
	public void fintech() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			 HttpHeaders headers = new HttpHeaders();
			 headers.set("X-RapidAPI-Host", host);
			 headers.set("X-RapidAPI-Key", key);
			 HttpEntity request = new HttpEntity(headers);
			 List<Stonk> stonks = new ArrayList();
			 List<String> stonkCodes = Arrays.asList("BCE","MDT","TPR","VOO");
			 LocalDateTime now = LocalDateTime.now();
			 for(int i=0;i<4;i++) {
				 ResponseEntity<String> response = restTemplate.exchange(
					"https://realstonks.p.rapidapi.com/"+stonkCodes.get(0),HttpMethod.GET, request, String.class);
				 ObjectMapper mapper = new ObjectMapper();
				 Stonk stonk = mapper.readValue(response.getBody(), Stonk.class);
				 stonks.add(stonk);
				 stonks.get(0).setName(stonkCodes.get(0));
			 	 stonks.get(0).setDayTime(now.toString());
			 }
			 System.out.println(stonks.toString());
			 	stonkRepo.save(stonks.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<DailyTemp> getAllData() {
		List<DailyTemp> tempList = tempRepo.findAll();
		return tempList;
	}

	@Override
	public void insertDate(String time, String temp) {
		// TODO Auto-generated method stub
		System.out.println("ok");
	}
}
