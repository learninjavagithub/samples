package com;

import java.io.IOException;

public class MultipleExceptionOrder {

	public static void main(String[] args) {
		
		try {
			
			throw new IOException();
		} catch (Exception e) {
			System.out.println("In Exception block");
		}/* catch (IOException ioe) { // Throws compiler error : Unreachable block
			System.out.println("In IObException block");
		}*/

	}

}
