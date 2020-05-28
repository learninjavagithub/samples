package com.streamexamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solutions {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");

		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950)
		);
		
		//1. Find all transactions in the year 2011 and sort them by value (small to high).
		findAllTransactions(transactions);
		
		System.out.println("*************************************************");
		//2. What are all the unique cities where the traders work?
		findAllUniqueCities(transactions);
		
		System.out.println("*************************************************");
		//3. Find all traders from Cambridge and sort them by name.
		findAllTradersFromCambridge(transactions);
		
		System.out.println("*************************************************");
		//4. Return a string of all traders’ names sorted alphabetically.
		findAllTradersByNamesSortedAsString(transactions);

		System.out.println("*************************************************");
		//5. Are any traders based in Milan?
		findIfAnyTradersInCity(transactions);

		System.out.println("*************************************************");
		//5. Are any traders based in Milan?
		findAllTradersInCity(transactions);
		
		System.out.println("*************************************************");
		//6. Print all transactions’ values from the traders living in Cambridge.
		findAllTraderValuesInCity(transactions);

		System.out.println("*************************************************");
		//7. What’s the highest value of all the transactions?
		findHighestValue(transactions);
		
		System.out.println("*************************************************");
		//8. Print all traders in Milan order by their name in desc order
		findTradersByNamesSortedReverse(transactions);

		/* How to remember. Think of each of the functions we used as a clauses in a DB query
		*  filter = WHERE
		*  map + collect = SELECT
		*  forEach = FOR LOOP
		*  sorted = ORDER BY
		*  distinct = DISTINCT
		*/
	}
	
	private static void findAllTransactions(List<Transaction> transactions) {
		
		transactions.stream()
					.filter(p -> p.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.collect(Collectors.toList())
					.forEach(s -> System.out.println(s + " "));
					
	}

	private static void findAllUniqueCities(List<Transaction> transactions) {
		
		transactions.stream()
					.map(p -> p.getTrader().getCity())
					.distinct()
					.collect(Collectors.toList())
					.forEach(s -> System.out.println(s + " "));
	}
	
	private static void findAllTradersFromCambridge(List<Transaction> transactions) {
		
		transactions.stream()
					.map(Transaction::getTrader)
					.filter(t -> t.getCity().equals("Cambridge"))
					.distinct()
					.sorted(Comparator.comparing(Trader::getName))
					.collect(Collectors.toList())
					.forEach(s -> System.out.println(s + " "));
	}
	
	private static void findAllTradersByNamesSortedAsString(List<Transaction> transactions) {
		
		String result = transactions.stream()
					.map(t -> t.getTrader().getName())
					.distinct()
					.sorted()
					.reduce("Result is : ", (res, elt) -> (res + elt + " "));
		// reduce syntax - first arg = initial value, second arg = again 2 params -> function to do
		// first param = temp result like temp total
		// second param = element value
		System.out.println(result);
	}
	
	private static void findIfAnyTradersInCity(List<Transaction> transactions) {
		
		boolean result = transactions.stream()
									 .anyMatch(t -> t.getTrader().getCity() == "Milan");
		
		System.out.println(result);
	}
	
	private static void findAllTradersInCity(List<Transaction> transactions) {
		
		transactions.stream()
					.filter(t -> t.getTrader().getCity() == "Milan")
					.map(t -> t.getTrader().getName())
					.distinct()
					.forEach(s -> System.out.print(s + " "));
	}
	
	private static void findAllTraderValuesInCity(List<Transaction> transactions) {
		
		transactions.stream()
					.filter(t -> t.getTrader().getCity() == "Cambridge")
					.map(t -> t.getValue())
					.forEach(s -> System.out.print(s + " "));
					
	}
	
	private static void findHighestValue(List<Transaction> transactions) {
		
		Optional<Transaction> result = transactions.stream()
					.max(Comparator.comparing(Transaction::getValue));
		
		System.out.println(result);
	}
	
	private static void findTradersByNamesSortedReverse(List<Transaction> transactions) {
		
		transactions.stream()
					.map(t -> t.getTrader().getName())
					.sorted(Comparator.reverseOrder())
					.forEach(System.out::println);
	}
}
