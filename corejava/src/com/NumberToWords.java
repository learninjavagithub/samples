package com;

public class NumberToWords {

	public static void main(String[] args) {
		
		int input = 1234;
		
		int number = Integer.parseInt(new StringBuilder(String.valueOf(input)).reverse().toString());
				
		int remainder = -1;
		int length = 1;
		while (number > 0) {
		
			//System.out.println("length=" + String.valueOf(number).length());
			length = String.valueOf(number).length();
			//System.out.println("Number is : " + number);
			remainder = number % 10;
			//System.out.println("Remainder is : " + remainder);
			//
			number = number / 10;
			convertToWords(length, remainder);
		}

	}
	
	public static void convertToWords(int numberOfDigits, int number) {
		//System.out.println("numberOfDigits = " + numberOfDigits);
		System.out.println(number);
		switch (numberOfDigits) {
			case 5 : System.out.println("Thousand");break;
			case 4 : System.out.println("Thousand");break;
			case 3 : System.out.println("Hundred");break;
			case 2 : 
					switch (number) {
						case 10 : System.out.println("Ten");break;
						case 2 : System.out.println("Twenty");break;
						case 3 : System.out.println("Thirty");break;
						case 4 : System.out.println("Fourty");break;
						case 5 : System.out.println("Fifty");break;
						case 6 : System.out.println("Sixty");break;
						case 7 : System.out.println("Seventy");break;
						case 8 : System.out.println("Eighty");break;
						case 9 : System.out.println("Ninety");break;
					}
					break;
			case 1 : 
					switch (number) {
						case 1 : System.out.println("One");break;
						case 2 : System.out.println("Two");break;
						case 3 : System.out.println("Three");break;
						case 4 : System.out.println("Four");break;
						case 5 : System.out.println("Five");break;
						case 6 : System.out.println("Six");break;
						case 7 : System.out.println("Seven");break;
						case 8 : System.out.println("Eight");break;
						case 9 : System.out.println("Nine");break;
					}
					break;
		}
	}
}