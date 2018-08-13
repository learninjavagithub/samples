package com.learninjava;

import java.util.ArrayList;
import java.util.List;

public class AngryBird {

	public int size;
	
	public String color;
	
	public List<Egg> eggs = new ArrayList<Egg>();

	public AngryBird(int size, String color) {
		this.size = size;
		this.color = color;
	}

	public int hashCode() {
		return size;
	}

	public boolean equals(Object obj) {
		
		boolean flag = false;
		AngryBird angryBird = (AngryBird) obj;
		if (angryBird.size == size && 
				angryBird.color == color) {
			flag = true;
		}
		return flag;
	}
}