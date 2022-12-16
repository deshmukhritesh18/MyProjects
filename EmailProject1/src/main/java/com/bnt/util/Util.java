package com.bnt.util;


public class Util {
	
	public static boolean isEmailFormatValid(String mailId) {
		
		if (mailId.matches("[A-Za-z]+[0-9+_.-]*[+@]{1,2}[a-z]+[+.]?[a-z]{2,3}")){
			 return true;
		}else{
			return false;
		}
		
	}


}
