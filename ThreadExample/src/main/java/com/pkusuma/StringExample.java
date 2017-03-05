package com.pkusuma;

public class StringExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcde";
		System.out.println(reverseStr(str));
		
		reverseMyStr(str);
		
	}
	
	static String reverseStr(String s) {
		
		if (s.length() == 0) {
			return "";			
		}
		return s.charAt(s.length()-1) + reverseStr(s.substring(0, s.length()-1));
	}

	static void reverseMyStr(String s) {
		
		if (!s.isEmpty()) {
			int len = s.length()-1;
			System.out.print(s.substring(len));
			reverseMyStr(s.substring(0, len));
		}
	}

}
