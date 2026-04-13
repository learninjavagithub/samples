package com.lambdas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class LambdaIntegerOperations {

	public static void main(String[] args) throws IOException {

		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}

class MyMath {
	
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public static PerformOperation isPrime() {
		        
        return new PerformOperation() {

			@Override
			public boolean check(int a) {
				
				return IntStream.rangeClosed(2,  a/2).allMatch(n -> a % n != 0);
			}  
	    };
	}

	public static PerformOperation isOdd() {
		        
		        return new PerformOperation() {

					@Override
					public boolean check(int a) {
						
						return IntStream.of(a).allMatch(b -> a % 2 != 0);
					}
		        };		        
		    }

	public static PerformOperation isPalindrome() {
		        
		        return new PerformOperation() {

					@Override
					public boolean check(int a) {
						
						return (a == IntStream.iterate(a, i -> i / 10)
                                .map(n -> n  % 10)
                                .limit(String.valueOf(a).length())
                                .reduce(0, (x, y) -> x * 10 + y));
					}
		    };
	}
}
