package com.pankaj.java.completablefutrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class future {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {

				Future<String> completable = calculateAsync();
				System.out.println(completable.get());
				System.out.println(completable.getClass().getName());
				System.out.println("Hello World");
			} 
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			catch (ExecutionException e) {
				e.printStackTrace();
			}
			
			CompletableFuture<String> completableFuture
			  = CompletableFuture.supplyAsync(() -> "Supply Async");
			CompletableFuture<Void> future = completableFuture
					  .thenAccept(s -> System.out.println("Computation returned: " + s));
			CompletableFuture<String> future2
			  = CompletableFuture.supplyAsync(() -> "Supply Async2");
			
			CompletableFuture<String> completableFuture2 
			  = CompletableFuture.supplyAsync(() -> "Hello")
			    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " In Compose"));
			 
			try {
				System.out.println(completableFuture2.get());
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				System.out.println(future2.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	public static Future<String> calculateAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		
		Executors.newCachedThreadPool().submit(() ->{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		completableFuture.complete("Hello");
		return null;
		});
		return completableFuture;
	}

}
