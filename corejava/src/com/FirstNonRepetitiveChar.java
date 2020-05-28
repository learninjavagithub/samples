package com;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepetitiveChar {

	public static void main(String[] args) {
		
		String st = "Some String";
		
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (char c: st.toCharArray()) {
			if (map.containsKey(c)) {
				int cnt = (int) map.get(c);
				map.put(c,  cnt + 1);
			} else {
				map.put(c,  1);
			}
		}
		System.out.println(map);
		for(Character key: map.keySet()) {
			Integer val = map.get(key);
			if (val == 1) {
				System.out.println(key);
				break;
			}
		}
	}
}