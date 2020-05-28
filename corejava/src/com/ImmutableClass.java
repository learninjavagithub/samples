package com;

public class ImmutableClass {

	public static void main(String[] args) {
		MyImmutableClass obj = new MyImmutableClass(1, "gan");
		System.out.println(obj.getId() + " " + obj.getName());
	}
}

/**
 * Steps: 
 * 1. Make class as final
 * 2. Make all variables as private final
 * 3. Use constructor to set all the values
 * 4. Remove all setter methods
 */
final class MyImmutableClass {
	private final int id;
	private final String name;
	
	MyImmutableClass(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}