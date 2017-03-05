package com.learninjava;

import java.util.Set;
import java.util.HashSet;

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

class AngryBird {

	public int size;
	
	public String color;

	public AngryBird(int size, String color) {
		this.size = size;
		this.color = color;
	}

	public int hashCode() {
		return size;
	}

	public boolean equals(Object obj) {
		
		boolean flag = false;
		AngryBird angryBird = (AngryBird) obj;
		if (angryBird.size == size && 
				angryBird.color == color) {
			flag = true;
		}
		return flag;
	}
}

