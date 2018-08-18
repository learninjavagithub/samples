package com;

import java.util.ArrayList;
import java.util.Stack;

public class BalancedExpressions {

	public static void main(String[] args) {
		
		String exp = "[()]{}{[()()]()}"; // balanced
		//String exp = "[(])"; // non-balanced
		
		String closingExps = "})]";
		//isBalancedExpressionUsingStack(exp, closingExps);
		
		isBalancedExpressionUsingArrayList(exp, closingExps);
		
	}
	
	private static void isBalancedExpressionUsingStack(String exp, String closingExps) {
		
		Stack<Character> stack = new Stack<>();
		
		char exps[] = exp.toCharArray();
		for (char c : exps) {
			
			if (stack.size() > 0) {
				char tos = stack.lastElement();
				if ( closingExps.contains("" + c) && 
						isSameExpression(tos, c) ) {
					
					System.out.println("Stack before pop: " + stack);
					stack.pop();
					System.out.println("Stack after pop: " + stack);
				} else {
					stack.push(c);
				}
			} else {
				System.out.println("Pushing element : " + c);
				stack.push(c);
			}
		}
		
		System.out.println("Stack size is : " + stack.size());
	}
	
	private static void isBalancedExpressionUsingArrayList(String exp, String closingExps) {
		
		ArrayList<Character> stack = new ArrayList<>();
		
		char exps[] = exp.toCharArray();
		for (char c : exps) {
			
			if (stack.size() > 0) {
				char tos = stack.get(stack.size()-1);
				if ( closingExps.contains("" + c) && 
						isSameExpression(tos, c) ) {
					
					System.out.println("Stack before pop: " + stack);
					stack.remove(stack.size()-1);
					System.out.println("Stack after pop: " + stack);
				} else {
					stack.add(c);
				}
			} else {
				System.out.println("Pushing element : " + c);
				stack.add(c);
			}
		}
		
		System.out.println("Stack size is : " + stack.size());
	}

	private static boolean isSameExpression(char char1, char char2) {
		
		if (char1 == '(' && char2 == ')') { 
			return true;
		} else if (char1 == '[' && char2 == ']') {
			return true;
		} else if (char1 == '{' && char2 == '}') {
			return true;
		} else {
			return false;
		}		
	}

}