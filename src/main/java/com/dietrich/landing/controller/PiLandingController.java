package com.dietrich.landing.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dietrich.landing.entity.LedEntity;
import com.dietrich.landing.entity.DailyTemp;
import com.dietrich.landing.entity.firstdb;
import com.dietrich.landing.repo.ExampleDbRepo;
import com.dietrich.landing.svc.PiTempCollectorSvc;
import com.dietrich.landing.svc.UploaderSvc;

@RestController
@EnableScheduling
public class PiLandingController /* running other jars stuff, implements ApplicationContextAware */ {

	@Autowired
	PiTempCollectorSvc tempCollector;
//	@Scheduled(cron="0 0/30 6,16 * * MON-FRI", zone="MST")
	@Scheduled(cron="0 0 12 * * MON-FRI", zone="MST")
	@GetMapping("/int")
	public void call() {
		System.out.println("ran");
		tempCollector.fintech();
	}

	@GetMapping("/db")
	public void db() {
		List<DailyTemp> tempList = tempCollector.getAllData();
		for(int i=0;i<tempList.size();i++) {
			System.out.println(tempList.get(i).toString());
		}
	}
//	@Scheduled(cron="0 0 6 * * *")
	@GetMapping("/scrape")
	public void tempuratureArduinoCaller() {
		
		try {
			String url = "http://192.168.0.10/W";
			Document document = Jsoup.connect(url).get();
			Elements paragraphs = document.getElementsByTag("p");
			System.out.println(paragraphs.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
