package com.lambdas;

import java.util.Arrays;
import java.util.List;

public class NoOfIncDec {

	public static void main(String[] args) {
		
		List<Integer> a = Arrays.asList(1234, 4321); 
		List<Integer> b = Arrays.asList(7851, 1128);
		
		// Result : abs(1-7) = 6 + 6 + 2 + 3 + 3 + 2 + 0 + 7 = 29
		System.out.println(numberOfIncDec(a, b));
	}
	
	static int numberOfIncDec(List<Integer> a, List<Integer> b) {
		
		int result = 0;
		for(int i = 0; i < a.size(); i++) {
			
			result = result + checkDiff(a.get(i), b.get(i));
		}
		return result;
	}
	
	static int checkDiff(int a, int b) {
		
		char[] ch1 = String.valueOf(a).toCharArray();
		char[] ch2 = String.valueOf(b).toCharArray();
		
		int sum = 0;
		for (int i = 0; i < ch1.length; i++) {
			
			sum = sum + Math.abs(Character.getNumericValue(ch1[i]) - Character.getNumericValue(ch2[i]));
		}
		return sum;
	}

}
