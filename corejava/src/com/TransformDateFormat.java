package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformDateFormat {

	public static void main(String[] args) {
		
		String inputDateStr = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		System.out.println("Original Date format is : " + inputDateStr);
		
		try {
			Date outputDate = new SimpleDateFormat("yyyy/MM/dd").parse(inputDateStr);
			System.out.println("Transformed Date format is : " + 
					new SimpleDateFormat("dd/MM/yy").format(outputDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
