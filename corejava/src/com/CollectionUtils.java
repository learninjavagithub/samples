package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CollectionUtils {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("one", "two", "threee");
		
		//HashSet<String> hSet = new HashSet<>();
		//hSet.addAll(list);
		
		// OR
		
		// NOTE :  HashMap will always return the value associated with the key, null if no value exists
		// HashSet will always return the result of the add operation, true if added successfully, false if elt is
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
	}

}
