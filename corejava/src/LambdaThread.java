package com;

public class LambdaThread {

	public static void main(String[] args) {
		
		// Step 1
		Runnable thread1 = () -> {
			
			System.out.println(Thread.currentThread().getName());
		};
		
		thread1.run(); // This is not a thread. Its just a method invocation
		
		// Step 2
		Thread thread2 = new Thread(thread1);
		thread2.start();

		// Step 1 and Step 2
		Thread thread3 = new Thread( () -> {
			
			System.out.println(Thread.currentThread().getName());
		});
		thread3.start();
		
		new Thread( () -> { System.out.println(Thread.currentThread().getName()); }).start();
	}

}
