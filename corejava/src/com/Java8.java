package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 implements Offer {

	@Override
	public void meth1() {
		System.out.println("Implementation");
	}
	
	public static void main(String... args) {
		
		new Java8().meth2();
		Offer.meth4();
		
		String s1 = "abc";
		String s2 = new String("abc").intern();
		
		System.out.println("Are these instances same ? "+(s1 == s2));
		
		Integer a  = 11_22; // Can have underscores in literals
		System.out.println(a);
		
		new Java8().java8Function();
		new Java8().compose();
		
	    optional();

	}

	private void java8Function() {
		
		// First Example
		Function<String, Boolean> convert = (i) -> {
			
			if(i.equals("one")){
				return true;
			} else {
				return false;
			}
		};
		
		System.out.println(convert.apply("one"));
		System.out.println(convert.apply("two"));
		System.out.println(convert.apply("1"));
		
		//Second Example
		String result = calc( (a) -> "Result: " + (a * 2), 10 );
	    System.out.println(result);
	    
	}
	
	private static String calc(Function<Integer, String> bi, Integer i) {
	    return bi.apply(i);
	} 
	
	private void compose() {
		
		Function<Integer, String> converter = (i) -> Integer.toString(i);
	    
	    Function<String, Integer> reverse = (s) -> Integer.parseInt(s);
	   
	    System.out.println(converter.apply(3).length());
	    // first send arg to function in compose(reverse) then to caller(converter)
	    System.out.println(converter.compose(reverse).apply("30").length()); 
	    // first send arg to caller(converter) then to function in compose(reverse) 
	    System.out.println(converter.andThen(reverse).apply(30).intValue());

	}
	
	private static void optional() {
		
		Optional<String> o = Optional.empty();
		System.out.println(o.toString());

		List<Account> list = Arrays.asList(new Account(1, "One"),
				   						   new Account(2, "Two"), 
				   						   new Account(3, "Three"));

		//Optional<Account> flag = 
		list.stream()
			.filter(account -> account.getAccountNo() > 1)
			//.findAny().ifPresent(s->System.out.println(s.getAccountName())); // Any item in random
			.forEach(account -> System.out.println(account.getAccountName())); // All items
		
		//System.out.println(flag.get().getAccountName());
		
		list.stream()
		  	.map(account -> account.getAccountName().toUpperCase())
		  	.collect(Collectors.toList())
		  	//.forEach(s -> System.out.println(s)); // All items;
	  		.forEach(System.out::println); // All items;
		
		System.out.println("\n");
		
		List<String> strList = new ArrayList<>(Arrays.asList("one", "two", "three"));
 		strList.stream()
		  		.mapToInt(s -> s.length())
		  		.forEach(System.out::println);
		
		/*.flatMap()
		.map(integer -> integer + 1)
        .collect(Collectors.toList());*/
	}
}

class Account {
	
	private int accountNo;
	private String accountName;
	
	public Account(int accountNo, String accountName) {
		this.accountNo = accountNo;
		this.accountName = accountName;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}		
}

@FunctionalInterface
interface Offer {
	
	public abstract void meth1();
	
	default void meth2() {
		System.out.println("In Default method of meth2");
	}
	default void meth3() {
		System.out.println("In Default method of meth3");
	}
	
	static void meth4() {
		System.out.println("In Static method");
	}
	static void meth5() {
		System.out.println("In Static method");
	}
	
	// can have functions from java.lang.Object 
	public String toString();
}
