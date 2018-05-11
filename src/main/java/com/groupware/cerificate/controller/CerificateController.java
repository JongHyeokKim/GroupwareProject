package com.groupware.cerificate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CerificateController {
	@RequestMapping("/certificateAdminList")
	public String certificateAdminList(Model model) {
		String url = "cerificate/certificateAdminList";
		return url;
	}
	@RequestMapping("/certificateAdminInformation")
	public String certificateAdminInformation(Model model) {
		String url = "cerificate/certificateAdminInformation";
		return url;
	}
	@RequestMapping("/certificateAdminWrite")
	public String certificateAdminWrite(Model model) {
		String url = "cerificate/certificateAdminWrite";
		return url;
	}
	@RequestMapping("/certificateAdminUpdate")
	public String certificateAdminUpdate(Model model) {
		String url = "cerificate/certificateAdminUpdate";
		return url;
	}

}
