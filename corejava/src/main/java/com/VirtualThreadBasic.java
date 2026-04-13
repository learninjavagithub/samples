package com;

public class VirtualThreadBasic {
    
    public static void main(String... args) {

        try {
            Thread thread = Thread.ofVirtual().start(() -> {
                System.out.println("Hello from " + Thread.currentThread());
            });

            Thread.sleep(1000);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
