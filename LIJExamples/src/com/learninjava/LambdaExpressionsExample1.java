package com.learninjava;


/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class LambdaExpressionsExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Using the Anonymous inner class syntax
		hitThePigUsingAngryBird(new AngryBird() {
			
			public void hitThePig() {
				System.out.println("Sucessfully sent an Anonymous bird to hit the pig...");
			}
		});

		// Using the new java 8 Lambda Expressions syntax
		hitThePigUsingAngryBird(() -> System.out.println("Sucessfully sent a Lambda Expression bird to hit the pig..."));
	}
	
	private static void hitThePigUsingAngryBird(AngryBird ab) {
		ab.hitThePig();
	}

	@FunctionalInterface
	public interface AngryBird {
		
		public void hitThePig();
	}
}