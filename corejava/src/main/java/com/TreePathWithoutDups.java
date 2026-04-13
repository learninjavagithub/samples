package com;

import java.util.ArrayList;
import java.util.List;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	
    public void solution(Tree T) {
        // write your code in Java SE 8
        
        int[] allPaths = new int[50000];
        // traverse all left and right nodes starting at root
        traversePath(T, allPaths, 0);
        
    }
    
    private void traversePath(Tree node, int[] allPaths, int length) {
        
        if (node == null) { // If last node then return
            return;
        } else {
            
            allPaths[length] = node.x;
            length++;
            
            if (node.l == null && node.r == null) { // leaf node so print
                displayPath(allPaths, length);
            } else {
                traversePath(node.l, allPaths, length);
                traversePath(node.r, allPaths, length);
            }
        }
        
    }
    
    private void displayPath(int[] allPaths, int length) {
    
        List list = new ArrayList();
        for(int i = 0; i < length; i++) {
            list.add(allPaths[i]);
        }
        // Check for duplicates in the path if present ignore the path
        // If not then display the count of that path
        
        
    }
}
class Tree {
	
	int x;
	Tree l;
	Tree r;
}