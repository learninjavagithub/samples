package com;

public class NumberToWords {

	public static void main(String[] args) {
		
		int input = 1234;
		
		int number = Integer.parseInt(new StringBuilder(""+input).reverse().toString());
				
		int remainder = -1;
		while (number > 0) {
		
			System.out.println("Number is : " + number);
			remainder = number % 10;
			System.out.println("Remainder is : " + remainder);
			//
			number = number / 10;
		}

	}
	
	public static void convertToWords(int numberOfDigits, int number) {
		
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
			case 1 : System.out.println("Thousand");break;
			
		}
	}
}