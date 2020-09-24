package com.pankaj.java;

public class Apple {
	
	String colour;
	int weight;

	public Apple(String colour, int weight) {
		super();
		this.colour = colour;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColour());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	public static void getColor(Apple apple) {
		String colour = apple.colour;
		System.out.println(colour);
	}

}
