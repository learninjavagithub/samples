package com;

public class PalindromeMatch {

	public static void main(String[] args) {


		int number = 121121;
		
		String numberStr = String.valueOf(number);
		
		String temp = numberStr;
		for (int i = 0; i < temp.toCharArray().length; i++) {
			
			temp = temp.substring(1, numberStr.length()) + temp.toCharArray()[0];
			
			System.out.println("Temp is : " + temp);
			if (temp.equals(numberStr)) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}
		}
	}
}