package com.bnt.service;

import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.bnt.model.MailDetails;
import com.bnt.util.Util;


@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public String sendMail(MailDetails mailDeteails) {
		try{
			if(Util.isEmailFormatValid(mailDeteails.getToEmailId())==true){
		 SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		 simpleMailMessage.setTo(mailDeteails.getToEmailId());
		 simpleMailMessage.setSubject(mailDeteails.getEmailSubject());
		 simpleMailMessage.setText(mailDeteails.getEmailMsgContent());
		 javaMailSender.send(simpleMailMessage);
		 return "Email Send ";
		 }else{
			 return "please enter valid email id";
		 }
		
		}catch(PatternSyntaxException e){
			//System.out.println(e);
			System.out.println("Email is empty or email pattern is not valid"+e);
			return "Faild to send Email";
		}
		
	}

	
}
