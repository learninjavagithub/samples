package com;

import java.util.ArrayList;
import java.util.List;

public class PairsWithSameSum {

	public static void main(String[] args) {
		
		int a[] = {10, 2, 3, 4, 6, 7, 20};
		PairsWithSameSum.getPairsWithSameSum(a, 10);
		
	}

	private static void getPairsWithSameSum(int a[], int sum) {
		
		List<Integer> list = new ArrayList<>();
		for(int item : a) {
			
			int diff = (sum - item);
			if (list.contains(diff)) {
				
				System.out.println("Found the pair: (" + item + ", " + diff + ")");
			} else {
				list.add(item);
			}			
		}		
	}
}
