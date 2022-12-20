package com.bnt.service;

import org.springframework.http.ResponseEntity;

import com.bnt.model.MailDetails;

public interface MailService {
	
	public ResponseEntity<String> sendMail(MailDetails mailDeteails);

	

}
