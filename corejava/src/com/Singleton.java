package com;

public class Singleton {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		MySingleton s1 = MySingleton.getInstance();
		System.out.println(s1.name);
		
		MySingleton s2 = MySingleton.getInstance();
		System.out.println(s2.name);
		
		// Trying to clone - Returns message from clone method
		System.out.println(s1.clone());
		
		// Trying newInstance - throws IllegalAccessException due to private constructor
		System.out.println(MySingleton.class.newInstance());
		
		//Disadvantages - uses volatile and will not work before java 1.4
		//Better alternative is to use Enum Singleton instead
	}
}

class MySingleton implements Cloneable {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private static volatile MySingleton myInstance = null;
	
	public String name = "MySingleton";
	
	private MySingleton() {
	}
	
	public static MySingleton getInstance() {
		if (myInstance == null) {
			synchronized(MySingleton.class) {
				if (myInstance == null) {
					System.out.println("New instance is created...");
					myInstance = new MySingleton();
				}
			}
		} else {
			System.out.println("Returning existing instance...");
		}
		return myInstance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//throw new CloneNotSupportedException(); // We can either throw an exception
		return "Clone is not supported"; // or return some friendly message
	}
}