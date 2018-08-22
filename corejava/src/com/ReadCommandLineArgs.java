package com;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadCommandLineArgs {

	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(new InputStreamReader(System.in))) {
		
			System.out.println("Reading input from console...");
			
			String arg1 = input.nextLine();
			System.out.println("First argument is : "+ arg1);
			
			int arg2 = input.nextInt();
			System.out.println("Second argument is : "+ arg2);			
		}

	}

}
