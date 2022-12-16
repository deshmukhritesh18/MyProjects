package com.bnt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.model.MailDetails;
import com.bnt.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@PostMapping(value = "/sendMail")
	public String getMail(@RequestBody MailDetails mailDeteails) {

		System.out.println(mailDeteails);
		return mailService.sendMail(mailDeteails);
	}
	
	
	@GetMapping(value = "/")
	public String m1(){
		return "Welcome to email sending application..";
	}

}
