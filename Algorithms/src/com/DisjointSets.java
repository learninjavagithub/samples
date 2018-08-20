package com;

public class DisjointSets {

	private int[] rank;
	private int[] parent;
	
	DisjointSets(int n) {
		
		rank = new int[n];
		parent = new int[n];
		
		// This can be created as a separate method (makeSet operation)
		for (int i = 0; i < n; i++) {
			
			parent[i] = i; // make all elements parents as themselves
		}
	}
	
	public int find(int i) {
		
		int rep = parent[i];
		if (rep == i) {
			
			return i;
		}
		return parent[i] = find(rep);
	}
	
	public void union(int elt1, int elt2) {
		
		int rep1 = find(elt1);
		int rep2 = find(elt2);
		
		if (rep1 == rep2) return;
		
		if (rank[rep1] > rank[rep2]) {
			
			parent[rep2] = rep1;
		} else if (rank[rep1] < rank[rep2]) {
			parent[rep1] = rep2;
		} else {
			parent[rep2] = rep1;
			rank[rep1]++;
		}
	}
	
	public static void main(String[] args) {
		
		DisjointSets ds = new DisjointSets(6);
		
		// 0 as a friend of 3
		ds.union(0, 3);
		
		// 4 as a friend of 5
		ds.union(4, 5);
		
		// 3 as a friend of 4
		ds.union(3, 4);
		
		// is 2 friend of 4
		if (ds.find(2) == ds.find(4)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		// is 4 friend of 5
		if (ds.find(4) == ds.find(5)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
