package com.learninjava;

/**
 * @author www.learninjava.com
 */
public class UserAndDaemonThreads {
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		/*Thread userThread = new Thread(new Runnable() {
			
			public void run() {
				
				while ( true ) {
					System.out.println("In run method of user thead...");
					try {
						Thread.sleep(3000);
						break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("In finally method of user thread...");
					}
				}
				
			}
		});
		userThread.start();*/

		
		Thread daemonThread = new Thread(new Runnable() {
			
			public void run() {
				
				while ( true ) {
					System.out.println("In run method of daemon thead...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("In finally method of daemon thread...");
					}
				}
				
			}
		});
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		daemonThread.join();

		System.out.println("Exiting main thread...");
	}

}
