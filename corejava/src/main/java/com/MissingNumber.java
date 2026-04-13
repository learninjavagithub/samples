package com;

public class MissingNumber {

	public static void main(String[] args) {
		
		int[] numbers = {2, 1, 3 ,5};
		
		int total = 5 * (5+1) / 2;  // n*(n+1)/2
		
		/*
		 1. Get the sum of numbers 
		 		total = n*(n+1)/2
		 2. Subtract all the numbers from sum and
		    you will get the missing number.
		 */
		System.out.println("Total is : " + total);
		
		int missingNo = total;
		for (int i : numbers) {
			missingNo = missingNo - i;
		}
		System.out.println("Missing number is : " + missingNo);
	}	

}
