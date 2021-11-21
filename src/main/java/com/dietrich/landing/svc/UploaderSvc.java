package com.dietrich.landing.svc;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface UploaderSvc {

	public String saveFile(MultipartFile file, RedirectAttributes redirectAttributes);
}
