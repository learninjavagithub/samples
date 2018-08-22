package com;

public class ReverseString {

	public static void main(String[] args) {
		
		System.out.println("Reversed String is : " + reverseString("ROTATOR"));
	}

	public static String reverseString(String numberStr) {
		
		String result = "";
		for (int i = numberStr.toCharArray().length - 1; i >= 0; i--) {

			result = result + numberStr.charAt(i);
		}
		return result;
	}
}
