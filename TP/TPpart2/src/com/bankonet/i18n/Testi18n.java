package com.bankonet.i18n;

import java.text.*;
import java.util.*;

public class Testi18n {

	public static void main(String[] args) {
		
		/** travail sur l'internationalisation des messages */
		String langage = "fr";
		String country = "FR";
		
		Locale currentLocale = new Locale(langage, country);
		
		ResourceBundle messages = ResourceBundle.getBundle("com.bankonet.i18n.resources", currentLocale);

			System.out.println(messages.getString("WELCOME"));
	
		/** travail sur l'internationalisation des nombres */
		Double currency = new Double(102312.05);
		NumberFormat currencyFormatter;
		String currencyOut;
			
		currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
		currencyOut = currencyFormatter.format(currency);
		System.out.println(currencyOut+ " " + currentLocale.toString());
			
		/** travail sur l'internationalisation des dates */
		
		DateFormat dFormat;
		dFormat = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);
		Date today = new Date();
		String dateOut = dFormat.format(today);
		System.out.println(dateOut+ " " + currentLocale.toString());
			
			
	}
	
	

}
