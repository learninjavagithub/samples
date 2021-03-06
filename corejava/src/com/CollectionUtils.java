package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class CollectionUtils {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("one", "two", "threee");
		
		//HashSet<String> hSet = new HashSet<>();
		//hSet.addAll(list);
		
		// OR
		
		// NOTE :  HashMap's put() will always return the value associated with the key, null if no value exists
		// HashSet will always return the result of the add() operation, true if added successfully, false if elt is
		// already present
		HashSet<String> hSet = new HashSet<>(list);
		
		hSet.add(null);
		hSet.add(null); // Since HashSet does not add a new element if already present it will not throw any error
		
		hSet.stream().forEach(System.out::println);

		System.out.println("###########");
		HashMap<String, String> map = new HashMap<>();
		System.out.println(map.put("one", "10")); // Will return null as elt does not exist yet
		System.out.println(map.put("one", "20")); // Will return 10 which is the value of existing elt
		
		map.values().stream().forEach(e -> {
				
			System.out.println("Element in map is : " + e);
		}
	    ); // will return 20 as elt is updated by above statement
		
		System.out.println(hSet.add("one"));// will return false if the element is not added successfully
		
		// Stream to find if a string or character is present
		boolean exists = Stream.of("one", "two", "three", "4", "5").anyMatch("6"::equals);
		System.out.println("Exists ? : " + exists);
		
		List<String> listOfStrings = Arrays.asList("one", "two", "three");
		
		String someString = "There are two or three apples...";
		
		boolean isPresent = listOfStrings.stream().anyMatch(someString::contains);
		System.out.println("Is Present ? : " + isPresent);
		
		List<Integer> numbersList = new ArrayList<>();
		numbersList.add(20);
		numbersList.add(10);
		numbersList.add(30);
		
		System.out.println(Collections.max(numbersList));
		
	}
}
