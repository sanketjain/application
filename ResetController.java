package com.aitacs.ams.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aitacs.ams.service.impl.MailService;

@RestController
@RequestMapping("/reset")
public class ResetController {

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetRequest(@RequestParam(value = "email") String email) {
		// check if the email id is valid and registered with us.
		mailService.sendMail(email);
		return "checkMail";
	}

	@RequestMapping(value = "/newPassword/{email}")
	public String resetPassword(@PathVariable String email, Map<String, String> model) {
		// check if the email id is valid and registered with us.
		model.put("emailid", email);
		return "newPassword";
	}
}
