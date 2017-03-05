package com.learninjava;


/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class LambdaExpressionsExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Using the Anonymous inner class syntax
		hitThePigUsingAngryBird(new AngryBird() {
			
			public void hitThePig(String birdColor) {
				System.out.println("Sucessfully sent an Anonymous bird with color " + birdColor + " to hit the pig...");
			}
		});

		// Using the new java 8 Lambda Expressions syntax
		hitThePigUsingAngryBird((String birdColor) -> System.out.println("Sucessfully sent a Lambda Expression bird with color " + birdColor + " to hit the pig..."));
	}
	
	private static void hitThePigUsingAngryBird(AngryBird ab) {
		String birdColor = "RED";
		ab.hitThePig(birdColor);
	}

	@FunctionalInterface
	public interface AngryBird {
		
		public static final String birdColor = "";
		public void hitThePig(String s);
	}
}
