package com.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		functionExamples();
		biFunctionExamples();
		predicateExamples();
	}
	
	private static void functionExamples() {
		System.out.println("################# Function Examples #################");
		Function<Integer, Boolean> isEven = new Function<Integer, Boolean>() {

			@Override
			public Boolean apply(Integer t) {
				return t % 2 == 0 ? true : false;
			}			
		};
		
		Function<Integer, Boolean> isOdd = n -> n % 2 != 0 ? true : false;
		System.out.println("Is this even ? " + isEven.apply(10));
		
		// Remember - When result is Boolean you cannot do andThen as it applies the function on the result
		// and since Integer function applied on Boolean does not make any sense, we can either use Predicate or just 
		// combine both results using && operator
		System.out.println("Is this even and odd ? " + (isEven.apply(100) && isOdd.apply(100)));
		
		Function<Integer, Integer> square = n1 -> n1 * n1;
		Function<Integer, Integer> cube = n1 -> (n1 * n1 * n1);
		
		System.out.println("Square and Cube of number is : " + square.andThen(cube).apply(5));		
	}
	
	private static void biFunctionExamples() {
		System.out.println("\n################# BiFunction Examples #################");
		BiFunction<Integer, Integer, Integer> area = new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer l, Integer b) {
				return l * b;
			}			
		};
		BiFunction<Integer, Integer, Integer> areaAgain = (l, b) -> l * b;
		System.out.println("Can calculate area like this: " + area.apply(10, 20));
		System.out.println("Can also calculate like this : " + areaAgain.apply(10, 20));
		// Remember - Chaining andThen uses a different function because of the same above reason
		System.out.println(area.andThen(area1 -> area1 * 2).apply(10, 20));
	}
	
	private static void predicateExamples() {
		System.out.println("\n################# Predicate Examples #################");
		Predicate<Integer> isEven = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};
		
		Predicate<Integer> isDividedByTen = n -> n % 10 == 0;
		Predicate<Integer> isGreaterThanTwo = n -> n > 2;
		
		System.out.println("Is this even ? " + isEven.test(10));
		// This works fine here because Predicate always returns a Boolean and can so we can chain them
		System.out.println("Combine both " + isEven.and(isDividedByTen).and(isGreaterThanTwo).test(10));
	}
}
