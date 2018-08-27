package com;

import java.util.Arrays;
import java.util.LinkedHashMap;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NearestLocations {

	public static void main(String[] args) {

		Solution1 solution = new Solution1();
		
		List<Integer> list1 = Arrays.asList(3, 6);
		List<Integer> list2 = Arrays.asList(2, 4);
		List<Integer> list3 = Arrays.asList(5, 3);
		List<Integer> list4 = Arrays.asList(2, 7);
		List<Integer> list5 = Arrays.asList(1, 8);
		List<Integer> list6 = Arrays.asList(7, 9);
		
		List<List<Integer>> allLocations = Arrays.asList(list1, list2, list3, list4, list5, list6);
				
		System.out.println(solution.nearestXsteakHouses(6, allLocations, 3));
		
		// Expected is : [[2, 4], [3, 6], [5, 3]]
	}

	
}

//CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution1
{
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, 
                                      List<List<Integer>> allLocations, 
                                      int numSteakhouses)
	{
     // WRITE YOUR CODE HERE
     
     // Calculate the distances first
     Map<List<Integer>, Double> distancesMap = new LinkedHashMap<>(); 
     double distances[] = new double[allLocations.size()];

     int i = 0;
     for (List<Integer> location : allLocations) {
         
         distances[i] = calculateDistanceForLocation(location);
         distancesMap.put(location, distances[i]);
         i++;
     }
     
     Map<List<Integer>, Double> mapOfNearestSteakHouses = distancesMap
         .entrySet()
         .stream()
         //.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // to sort in reverse
         .sorted(Map.Entry.comparingByValue())
         //.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (v1,v2)->v1, LinkedHashMap::new));
     //or
         .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
     // (v1, v2) -> v1 -- we do not want any merging here

     System.out.println("After Ordering:" + mapOfNearestSteakHouses);
     
     return mapOfNearestSteakHouses
         .keySet()
         .stream()
         .limit(numSteakhouses)
         .collect(Collectors.toList());
 }
 // METHOD SIGNATURE ENDS
 
 private static double calculateDistanceForLocation(List<Integer> location) {
     
     double distance = 0;
     for (Integer coordinate : location) {
         
         if ( coordinate < 0) {
             distance = distance - (coordinate * coordinate);
         } else {
             distance = distance + (coordinate * coordinate);
         }
     }
     System.out.println("Distance for location " + location + " is : " + Math.sqrt(distance));
     return Math.sqrt(distance);
 }
 
}