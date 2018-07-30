package com;

public class NullCasting {

	public static void main(String[] args) {
	
		// Scenario 1
		String st = (String) null;
		System.out.println(st); // works fine bcos of the code : return (obj == null) ? "null" : obj.toString();
		
		//System.out.println(st.toString()); // NPE
		
		// Scenario 2
		Thread t = null;
		t.yield(); // Calls static method Thread.yield() so this runs fine.
		System.out.println("yield call was successful...");
	}
}
