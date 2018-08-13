package com.learninjava;

import java.util.HashSet;
import java.util.Set;

/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class EqualsAndHashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AngryBird redBird = new AngryBird(1, "RED");
		AngryBird blueBird = new AngryBird(2, "BLUE");
		AngryBird blackBird = new AngryBird(3, "BLACK");
		
		Set<AngryBird> birdsSet = new HashSet<AngryBird>();
		birdsSet.add(redBird);
		birdsSet.add(blueBird);
		birdsSet.add(blackBird);
		
		
		AngryBird birdToFind = new AngryBird(1, "RED");
		System.out.println("HashCode of RED bird to find : " + birdToFind.hashCode() + "\n");
		
		System.out.println("HashCodes of birds in buckets...");
		for (AngryBird bird : birdsSet) {
			System.out.println("Color : " + bird.color + " HashCode : " + bird.hashCode() + "\n");
		}
		
		System.out.println("Is RED angry bird present in the buckets ? : " + birdsSet.contains(birdToFind));
	}
}