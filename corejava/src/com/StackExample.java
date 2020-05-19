package com;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		
		Stack<String> stackOfCards = new Stack<>();
		stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        
        System.out.println("Stack => " + stackOfCards);
        System.out.println("Size after Pop : " + stackOfCards.size());        
        
        System.out.println("Top element is :" + stackOfCards.get(0));
        System.out.println("First element is : " + stackOfCards.firstElement());
        System.out.println("Last element is : " + stackOfCards.lastElement());
        
        System.out.println("Popped element is : " + stackOfCards.pop());
        
        System.out.println("Size after Pop : " + stackOfCards.size());

	}

}
