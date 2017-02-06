package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorExample executorExample = new ExecutorExample();
		
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		Addition additionTask1 = executorExample.new Addition(1, 2);
		Addition additionTask2 = executorExample.new Addition(3, 4);
		Addition additionTask3 = executorExample.new Addition(5, 6);
		
		Future<Integer> future1 = threadPool.submit(additionTask1);
		Future<Integer> future2 = threadPool.submit(additionTask2);
		Future<Integer> future3 = threadPool.submit(additionTask3);
		System.out.println("Task is submitted...");
		
		while(!future1.isDone()) {
			System.out.println("Task is not completed Yet...");
			Thread.sleep(1000);
		}
		
		System.out.println("Task is completed, let's check result");

		System.out.println("The result of addition1 is : " + future1.get());
		System.out.println("The result of addition2 is : " + future2.get());
		System.out.println("The result of addition3 is : " + future3.get());

		// Shutdown Executor
		try {
		    System.out.println("Attempt to shutdown executor");
		    threadPool.shutdown();
		    threadPool.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("Tasks interrupted");
		}
		finally {
		    if (!threadPool.isTerminated()) {
		        System.err.println("Cancel non-finished tasks");
		    }
		    threadPool.shutdownNow();
		    System.out.println("Shutdown finished");
		}

	}

	public class Addition implements Callable<Integer> {
		
		private final int a;
		private final int b;
		
		public Addition(int a, int b) {
			
			this.a = a;
			this.b = b;
		}
		
		public int add(int a, int b) {
			
			return a + b;
		}
		
		public Integer call() throws InterruptedException {
			
			Thread.sleep(1000);
			return add(a, b);
		}
	}
}