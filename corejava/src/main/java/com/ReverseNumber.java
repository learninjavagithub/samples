package com;

public class ReverseNumber {

	public static void main(String[] args) {
		
		System.out.println("Reversed Number is : " + reverseNumber(12345));
	}

	public static int reverseNumber(int number) {
		
		int result = 0;
		while (number > 0) {
			result = result * 10 + number % 10;
			number = number / 10;
		}
		return result;
	}
}
