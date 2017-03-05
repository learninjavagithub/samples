package com.learninjava;

/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class FunctionalInterfaceExample2 {

	public static void main(String[] args) {
		
		// Call the method in functional interface directly
		FunctionalInterfaceExample2 functionalInterfaceExample = new FunctionalInterfaceExample2();
		// Since RedAngryBird is an inner class we will use the outer class instance
		RedAngryBird redAngryBird = functionalInterfaceExample.new RedAngryBird();
		redAngryBird.hitThePig();
		redAngryBird.hitThePigAgain();
	}
	
	@FunctionalInterface
	public interface AngryBird {
		
		public void hitThePig();
		
		// Adding method this way will result in a compiler error
		//public void hitThePigAgain();
		
		default public void hitThePigAgain() {
			System.out.println("Hit the pig using default Angry Bird...");
		}
	}

	class RedAngryBird implements AngryBird {
		
		public void hitThePig() {
			System.out.println("Hit the pig using Red Angry Bird...");
		}
	}
}
