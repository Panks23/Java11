package com.pankaj.java.price;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future; 


public class Shop {
	
	public static void main(String [] args) {
		Future<Double> future = getPriceAsync("Hi");
		
		Future<Double> future2 = getPricecWithSupplyAsync("Inception");
		
		Future<Void> future3 = getPriceWithRunAsync("Star Trek");
		System.out.println("I was supposed to print at last");
	}
	
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	private static double calculatePrice(String product) {
		delay();
		Random random = new Random();
		System.out.println("You are in calculate Price method for "+ product);
		return random.nextDouble() * product.charAt(0) + product.charAt(1); }
	
	
	public static void  delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Future<Double> getPriceAsync(String product){
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread( ()-> {
				double price = calculatePrice(product);
				futurePrice.complete(price);
				}).start();
		
		return futurePrice;
	}
	
	public static Future<Double> getPricecWithSupplyAsync(String product){
		System.out.println("I am full of supplies");
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	
	public static Future<Void> getPriceWithRunAsync(String product){
		System.out.println("Main Difference is it returns void as it takes runnable input");
		return CompletableFuture.runAsync(() -> calculatePrice(product));
	}
	
	

}


