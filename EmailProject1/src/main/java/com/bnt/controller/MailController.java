package com.bnt.controller;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bnt.model.MailDetails;
import com.bnt.service.MailService;
   
@RestController
public class MailController {
	
	private static Logger logger=LogManager.getLogger(MailController.class);
 
	
	@Autowired
	private MailService mailService;
	
	@PostMapping(value = "/sendMail")
	public ResponseEntity<String> getMail(@RequestBody MailDetails mailDeteails) {
		return mailService.sendMail(mailDeteails);
	}
	
	
	@GetMapping(value = "/")
	public String m1(){
		logger.error("Application Start ");
		return "Welcome to email sending application..";
	}

}
