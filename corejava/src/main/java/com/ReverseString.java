package com;

public class ReverseString {

	public static void main(String[] args) {
		
		System.out.println("Reversed String without using Function is : " + reverseString("ROTATORS"));
		
		System.out.println("Reverse Using Function is : " + new StringBuilder("ROTATORS").reverse());
	}

	public static String reverseString(String numberStr) {
		
		String result = "";
		for (int i = numberStr.toCharArray().length - 1; i >= 0; i--) {

			result = result + numberStr.charAt(i);
		}
		return result;
	}
}
