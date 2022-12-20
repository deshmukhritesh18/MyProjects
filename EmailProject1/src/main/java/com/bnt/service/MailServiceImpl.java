package com.bnt.service;

import java.util.regex.PatternSyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bnt.controller.MailController;
import com.bnt.model.MailDetails;
import com.bnt.util.Util;


@Service
public class MailServiceImpl implements MailService {
	
	private static Logger logger=LogManager.getLogger(MailController.class);

	@Autowired
	JavaMailSender javaMailSender;
	
	public ResponseEntity<String> sendMail(MailDetails mailDeteails) {
		String error="";
		try{
			if(Util.validateMail(mailDeteails).length()==0){
		 SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		 simpleMailMessage.setTo(mailDeteails.getToEmailId());
		 simpleMailMessage.setSubject(mailDeteails.getEmailSubject());
		 simpleMailMessage.setText(mailDeteails.getEmailMsgContent());
		 javaMailSender.send(simpleMailMessage);
		 return new ResponseEntity("Email send successfully ", HttpStatus.OK);
		 }else{
			 error=Util.validateMail(mailDeteails);
			 logger.error(error);
			 return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		 }
		
		}catch(Exception e){
			logger.error("Email send fail"+e.getMessage());
			return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
	}

	
}
