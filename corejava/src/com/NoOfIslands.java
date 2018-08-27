package com;

public class NoOfIslands {

	public static void main(String[] args) {

		int[][] island = new int[][] { 
			{ 1, 1, 0, 0, 0 }, 
			{ 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 0, 1 }, 
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 } };
		System.out.println(islandCount(island));

	}

	public static int islandCount(int[][] matrix) {
        int numIslands = 0;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == 1) {
                    removeIsland(matrix, x, y);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private static void removeIsland(int[][] matrix, int x, int y) {
        if (matrix[x][y] == 1) {
            matrix[x][y] = 0;
            if (x > 0) {
                removeIsland(matrix, x - 1, y);
            }
            if (x < matrix.length - 1) {
                removeIsland(matrix, x + 1, y);
            }
            if (y > 0) {
                removeIsland(matrix, x, y - 1);
            }
            if (y < matrix[x].length - 1) {
                removeIsland(matrix, x, y + 1);
            }
        }
    }
}