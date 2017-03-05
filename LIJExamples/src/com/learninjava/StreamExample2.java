package com.learninjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class StreamExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Red Bird");
		list.add("Yellow Bird");
		list.add("Blue Bird");
		list.add("Yellow Bird");
		
		System.out.println("Actual List : " + list);
		
		// Collect example using toSet
		Set<String> set = (Set<String>) list.stream()
											.map(String::toUpperCase)
											.collect(Collectors.toSet());		

		System.out.println("Collect example using toSet : " + set);
		
		// Collect example using toList
		List<String> birdsList = Stream.of("Blue Bird", "White Bird", "Black Bird")
									   .filter(b -> b.contains("l"))
									   .collect(Collectors.toList());
		
		System.out.println("Collect example using toList : " + birdsList);

		// Collect example using toMap
		AngryBird bird1 = new AngryBird(1, "BLUE");
		AngryBird bird2 = new AngryBird(2, "RED");
		AngryBird bird3 = new AngryBird(3, "BLACK");

		List<AngryBird> angryBirdsList = Arrays.asList(bird1, bird2, bird3);

		Map<Integer, String> angryBirdsMap = 
				angryBirdsList.stream()
					     	  .collect(Collectors.toMap(b -> b.size, b -> b.color));
		
		System.out.println("Collect example using toMap : " + angryBirdsMap);
		
		// Using flatMap()
		Egg egg1 = new Egg();
		egg1.size = 1;
		Egg egg2 = new Egg();
		egg2.size = 2;
		
		ArrayList<Egg> eggsList = new ArrayList<Egg>();
		eggsList.add(egg1);
		eggsList.add(egg2);
		
		bird1.eggs = eggsList;
		bird2.eggs = eggsList;
		bird3.eggs = eggsList;

		angryBirdsList.stream()
					  .flatMap(b -> b.eggs.stream())
					  .forEach(e -> System.out.println("Using flatMap() : " + e.size));
		
		// reduce() using Objects
		String biggestSizeBirdColor = angryBirdsList.stream()
				  									.reduce((b1, b2) -> b1.size > b2.size ? b1 : b2)
				  									.get().color;
		System.out.println("reduce() using Objects : " + biggestSizeBirdColor);

		// reduce() using primitives
		List<Integer> birdSizes = Arrays.asList(1, 3, 2, 5, 6);
		int birdSizesTotal = birdSizes.stream()
				 					  .reduce((b1, b2) -> b1 + b2)
				 					  .get();
		System.out.println("reduce() using primitivies : " + birdSizesTotal);
		
		
		// Parallel Streams
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("Parallel Streams default pool size : " + commonPool.getParallelism());
		
		list = new ArrayList<String>();
		list.add("Red Bird1");
		list.add("Red Bird2");
		list.add("Red Bird3");
		list.add("Red Bird4");
		list.add("Red Bird5");
		list.add("Red Bird6");
		list.add("Red Bird7");
		list.add("Red Bird8");
		list.add("Red Bird9");
		list.add("Red Bird10");

		list.parallelStream()
		    .filter(b -> {
			    System.out.println("Thread Name in filter : " + Thread.currentThread().getName());
			    return true;
		    })
		    .map(b -> {
			    System.out.println("Thread Name in map : " + Thread.currentThread().getName());
			    return b.toUpperCase();
		    })
		    .forEach(System.out::println);
		 
	}
	
}

/*class AngryBird {
	
	public int size;
	
	public String color;
	
	public List<Egg> eggs = new ArrayList<Egg>();
	
	AngryBird(int size, String color) {
		this.size = size;
		this.color = color;
	}
	
}*/

class Egg {
	
	public int size;
}