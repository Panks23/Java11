 package com.pankaj.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java {
		public static void main(String[] args) {
			
			List<Apple> apple = new ArrayList<>();
			apple.add(new Apple("red", 10));
			apple.add(new Apple("green", 200));
			apple.add(new Apple("red", 10));
			apple.add(new Apple("red", 10));
			apple.add(new Apple("green", 70));
			apple.add(new Apple("red", 10));
			apple.add(new Apple("green", 300));
			
			System.out.println("Using Lamda Expression");
			apple.stream().forEach(i -> System.out.println(i.colour));
			
			System.out.println("Using Method Reference");
			apple.parallelStream().forEach(Apple::getColor);
			List<Apple> appleList = filterApples(apple, Apple::isGreenApple);
			
			List<Apple> appleWeight = filterApples(apple, Apple::isHeavyApple);
			appleList.stream().forEach(s -> System.out.println(s.getColour()));
			appleWeight.stream().forEach(s -> System.out.println(s.getWeight()));
			
			
			System.out.println("Using functional Interface");
			MyLambda lambda = (a) -> a*2;
			System.out.println(lambda.foo(2));
			
			System.out.println(apple.stream().findFirst());
			Optional<Apple> app = apple.stream().findFirst();
			
			
			System.out.println(app.get().getWeight());	
			
			
			
			
			List<Integer> values = Arrays.asList(1, 8, 3, 4 ,5 );
			int result = 0;
			System.out.println(values.stream().map(i-> i*2).reduce(0, (e, c) -> c+ e));
			
			System.out.println(values.stream().map(i-> i+2).reduce(1, (e, c)-> c*e));
			
			System.out.println(values.stream().filter(i -> i%2==0).reduce(0, (c, e) -> c+e));
			System.out.println(values.stream().filter(i -> i%2==0).map(i -> i*2).findFirst());

			
			
		}
		
		public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
			List<Apple> result = new ArrayList<>();
			for(Apple apple: inventory) {
				if(p.test(apple)) {
					result.add(apple);
				}
			}
			return result;
		}
		
}

@FunctionalInterface
interface MyLambda{
	int foo(int a);
}