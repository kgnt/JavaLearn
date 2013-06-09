package com.taobao.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	private static int id = 13;

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		// ExecutorService exec = Executors.newCachedThreadPool();
		ExecutorService exec = Executors.newFixedThreadPool(2);
		ArrayList<Future<String>> resultList = new ArrayList<Future<String>>();

		resultList.add(exec.submit(new TaskWithResult(id)));
		resultList.add(exec.submit(new TaskWithResult(id + 1)));

		while (!resultList.get(0).isDone() || !resultList.get(1).isDone()) {
			Thread.sleep(1000);
			System.out.println("sleep 1s ...");
		}
		System.out.println(resultList.get(0).get());
		System.out.println(resultList.get(1).get());
		exec.shutdown();
	}
}

class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		Thread.sleep(3000);
		return "result of TaskWithResult " + id;
	}
}