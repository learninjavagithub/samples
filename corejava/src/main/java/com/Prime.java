package com;

import java.util.stream.IntStream;

public class Prime {

	public static void main(String[] args) {
		
		System.out.println(isPrime(5));
		
		// Prime Series
		for (int i = 2; i <= 20; i++) {
			
			//if (isPrime(i)) {
			if (isPrimeUsingLambdas(i)) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println("");
		System.out.println("Number is odd : " + isOdd(8));
	}
	
	private static boolean isPrime(int number) {
		
		boolean result = true;
		for(int i = 2; i <= number/2; i++) {
			
			if (number%i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static boolean isPrimeUsingLambdas(int n) {
		
		return IntStream.rangeClosed(2, n/2).allMatch(a -> n % a != 0);
		
	}
	
	private static boolean isOdd(int n) {
		
		return IntStream.of(n).allMatch(a -> a % 2 != 0);
	}

}
