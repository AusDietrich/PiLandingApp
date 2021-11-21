package com.dietrich.landing.svc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class UploaderSvcImpl implements UploaderSvc{

	private static String FILE_LOCATION = "/";	
	@Override
	public String saveFile(MultipartFile file,RedirectAttributes redirectAttributes) {

       
		return "saved";
	}
}
