package no.hvl.dat108.hjelpeklasser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.hvl.dat108.entiteter.Deltager;

public class Validator {
	
	
	//bindestrek og mellomrom
	public static boolean validateFirstName(String name) {
		
		if (name.length() < 2 || name.length() > 20) {
			return false;
		}

		Pattern p = Pattern.compile("^[ÆØÅæøåA-Za-z- ]+$");
		Matcher m = p.matcher(name);
		
		
		return m.find() && firstLetterCapital(name);
		
		
		
	}
	
	//bindestrek
	public static  boolean validateLastName(String name) {
		
		if (name.length() < 2 || name.length() > 20) {
			return false;
		}

		Pattern p = Pattern.compile("^[ÆØÅæøåA-Za-z-]+$");
		Matcher m = p.matcher(name);
		
		return m.find() && firstLetterCapital(name);
		
	}
	
	public static boolean gyldigKjoenn(String kjoenn) {
		char gender = kjoenn.charAt(0);
		
		return (gender == 'K' || gender=='M');
	}
	
	public static boolean validatePhoneNumber(String phonenumber) {
		
		return phonenumber != null && phonenumber.matches("^\\d{8}$");
		
	}
	
	public static boolean validatePassword(String password) {
		
		boolean upperCases = false;
		
		char[] array = password.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (Character.isUpperCase(array[i])) {
				upperCases = true;
			}
		}
		
		return (password.length() > 8 && password.length() < 20 && upperCases);
		
	}
	
	private static boolean firstLetterCapital(String name) {

		char firstLetter = name.charAt(0);
		if (!Character.isUpperCase(firstLetter)) {
			return false;
		}
		return true;
	}
	
	

}
