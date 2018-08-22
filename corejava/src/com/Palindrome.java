package com;

public class Palindrome {

	public static void main(String[] args) {


		int number = 121121;
		System.out.println(isPalindrome(number));
		
	}
	
	public static boolean isPalindrome(int number) {
		
		int sum = 0;
		int temp = number;
		
		while (number > 0) {
			
			sum = sum * 10 + (number % 10);
			number = number / 10;
			
			System.out.println("sum is :" + sum);
		}
		
		return (sum == temp) ? true : false;
	}
}