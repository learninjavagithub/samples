package com.pkusuma;

/**
 * Hello world!
 *
 */
public class Thread2 extends Thread
{
	
	public void run() {
		
		System.out.println("Iam running from Thread [Name = "+Thread.currentThread().getName()+"]");
	}
	
    public static void main( String[] args ) throws Exception
    {
    	Thread2 thread2 = new Thread2();
    	thread2.start();
    	thread2.run(); // is possible but will run as part of Main thread not as new thread
    }
}
