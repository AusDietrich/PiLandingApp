package com.dietrich.landing.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PiLandingController implements ApplicationContextAware {

	private ApplicationContext context;

	@GetMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if (request.isUserInRole("uppy")) {
			modelAndView.setViewName("uploys.html");
		} else if (request.isUserInRole("deppy")) {
			modelAndView.setViewName("deploys.html");
		}
		System.out.println(System.getProperty("user.dir"));
		// Creating object of class File where
		// Dot represents the current directory
		File currentDir = new File(System.getProperty("user.dir"));
		displayDirectory(currentDir);
		return modelAndView;
	}

	public static void displayDirectory(File dir) {

		try {
			File[] files = dir.listFiles();

			// For-each loop for iteration
			for (File file : files) {

				// Checking of file inside directory
				if (file.isDirectory()) {

					// Display directories inside directory
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectory(file);
				}

				// Simpley get the path
				else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		}

		// if any exceptions occurs printStackTrace
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/shutdown")
	public void shutdown() {
		((ConfigurableApplicationContext) context).close();
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context = ctx;
	}

}
