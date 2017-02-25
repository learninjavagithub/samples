package com;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {1, 3, 2, 7, 4, 8, 6};
		
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			
			int flag = 0;
			for (int j = 0; j < n - i - 1; j++) {
				
				if (arr[j] > arr[j+1]) {
				
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp; 
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
			System.out.println(Arrays.toString(arr));
		}

		System.out.println(Arrays.toString(arr));
	}

}
