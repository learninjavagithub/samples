package com;

import java.util.stream.IntStream;

public class Palindrome {

	public static void main(String[] args) {


		int number = 121121;
		System.out.println(isPalindromeUsingLambdas(number));
		
	}
	
	public static boolean isPalindrome(int number) {
		
		int sum = 0;
		int temp = number; // 121
		
		while (number > 0) {
			
			sum = sum * 10 + (number % 10); // 0 * 10 + 1 = 1,  1 * 10 + 2 = 12, 12 * 10 + 1 = 121
			number = number / 10;  // 12 , 1, 0.1
			
			System.out.println("sum is :" + sum);
		}
		
		return (sum == temp) ? true : false;
	}
	
	public static boolean isPalindromeUsingLambdas(int number) {
		
		return number == IntStream.iterate(number, i -> i / 10)
								  .map(n -> n  % 10)
								  .limit(String.valueOf(number).length())
								  .reduce(0, (a, b) -> a * 10 + b);
	}
}