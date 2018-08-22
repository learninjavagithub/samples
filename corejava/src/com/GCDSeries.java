package com;

public class GCDSeries {

	public static void main(String[] args) {
		
		//int[] arr = {2, 3, 4, 5, 6}; // GCD = 1
		int[] arr = {2, 4, 6, 8, 0}; // GCD = 2
		
		System.out.println("GCD is : " + calculateGCDSeries(4, arr));
	}
	
	private static int calculateGCDSeries(int num, int[] arr) {
		
		int result = arr[0];
		
		for ( int i = 1; i < num; i++) {
			
			result = calculateGCD(arr[i], result);
		}
		return result;
	}
	
	private static int calculateGCD(int a, int b) {
		
		return (b == 0) ? a : calculateGCD(b, a%b);
		
		// This solution throws Stackoverflowerror in amazon code test UI 
		/*
		if ( a == 0 || b == 0 ) return 0;
		
		if ( a == b ) {
			return a;
		}
		if ( a > b ) {
			return calculateGCD(a-b, b);
		} else {
			return calculateGCD(a, b-a);
		}
		*/
	}
}
