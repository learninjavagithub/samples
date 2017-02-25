package com;

import java.util.Arrays;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {3, 2, 7, 4, 8, 6};
		
		int n = arr.length;
		int temp;
		int min;
		for (int i = 0; i < n-1; i++) {
			
			min = i;
			for (int j = i+1; j < n; j++) {
				
				if (arr[j] < arr[min]) {
					min = j;
				}
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp; 
			}
		}

		System.out.println(Arrays.toString(arr));
	}

}
