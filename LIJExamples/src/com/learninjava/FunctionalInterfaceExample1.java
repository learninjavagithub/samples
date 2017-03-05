package com.learninjava;

/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class FunctionalInterfaceExample1 {

	public static void main(String[] args) {
		
		// Call the method in functional interface directly
		FunctionalInterfaceExample1 functionalInterfaceExample1 = new FunctionalInterfaceExample1();
		// Since RedAngryBird is an inner class we will use the outer class instance
		RedAngryBird redAngryBird = functionalInterfaceExample1.new RedAngryBird();
		redAngryBird.hitThePig();

	}
	
	@FunctionalInterface
	public interface AngryBird {
		
		public void hitThePig();
		
	}

	class RedAngryBird implements AngryBird {
		
		public void hitThePig() {
			System.out.println("Hit the pig using Red Angry Bird...");
		}
	}
}
