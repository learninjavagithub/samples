package com.pkusuma;

/**
 * Hello world!
 *
 */
public class Thread1
{
    public static void main( String[] args ) throws Exception
    {
     
    	// wait for messages
       System.out.print("waiting for messages");
       for (int i = 0; i < 10; i++) {
          Thread.sleep(1000);
          System.out.print(".");
       }
    	System.out.println( "Hello World!" );
    }
}
