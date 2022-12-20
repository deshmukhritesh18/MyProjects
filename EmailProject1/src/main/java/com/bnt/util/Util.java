package com.bnt.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bnt.controller.MailController;
import com.bnt.model.MailDetails;

public class Util {
	private static Logger logger=LogManager.getLogger(Util.class);
	//for checking object is not null
	public static String validateMail(MailDetails mailDeteails) {
		String error="";			
			if (mailDeteails != null) {
				if (mailDeteails.getToEmailId() == null || mailDeteails.getToEmailId().trim().isEmpty()) {
					error = error.concat("Please provide valid email id  ");

				}else if( mailDeteails.getToEmailId()!= null && mailDeteails.getToEmailId().matches("[A-Za-z]+[0-9+_.-]*[+@]{1,2}[a-z]+[+.]?[a-z]{2,3}") != true  ) {
					error = error.concat("Please enter valid Syntaxe for mail id ");
				}
				
				else if (mailDeteails.getEmailSubject() == null || mailDeteails.getEmailSubject().trim().isEmpty()) {
				error = error.concat(" Please Enter Email Subject ");
				
			}
				
				
				else if (mailDeteails.getEmailMsgContent() == null || mailDeteails.getEmailMsgContent().trim().isEmpty()) {
				error = error.concat("Please enter Email Content ");

			}
			
		} else {
			error = error.concat("Please provide email id, email subject and email content ");
			
		}
			
			return error;
		
	
/*	// fro checking data is not blank
	public static boolean isBlank(String stringObject) {
		boolean result = false;
		if (stringObject == null || stringObject.isEmpty()) {
			result = true;
		}
		return result;
	}
	


	public static Date getDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		// Set time fields to zero
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// Put it back in the Date object
		return cal.getTime();
	}
*/
}}
