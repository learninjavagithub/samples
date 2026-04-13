package com;

import java.util.stream.Stream;

public class Fibonacci {

	public static void main(String[] args) {
		
		// 0, 1, 1, 2, 3, 5, 8, 13
		fiboUsingLoop(10);
		
		System.out.println("");
		System.out.print(fiboUsingRecursion(10) + ", ");
		
		System.out.println("");
		fiboUsingLambdas(11);
	}

	private static void fiboUsingLoop(int n) {
		
		int prev = 0, pres = 1, sum = 0;
		System.out.print(prev + ", " + pres + ", ");
		for (int i = 1; i < n; i++) {
			
			sum = (prev + pres);
			System.out.print(sum + ", ");
			prev = pres;
			pres = sum;
		}
	}
	
	private static int fiboUsingRecursion(int n) {
		
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return (fiboUsingRecursion(n-1) + fiboUsingRecursion(n-2));
	}
	
	private static void fiboUsingLambdas(int limit) {
		
		Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0] + a[1]})
			  .limit(limit)
			  .map(a -> a[0]) // selects first element from the 2 element array created in iterate
			  .forEach(s -> System.out.print(s + ", "));
	}
}