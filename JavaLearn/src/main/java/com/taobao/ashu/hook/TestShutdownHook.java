package com.taobao.ashu.hook;

public class TestShutdownHook {

	public static void main(String[] args) {
		// 定义线程1
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("thread1...");
			}
		};
		
		// 定义线程2
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("thread2...");
			}
		};
		
		// 定义关闭线程
		Thread shutdownThread = new Thread() {
			public void run() {
				System.out.println("shutdownThread...");
			}
		};
		
		// jvm关闭的时候先执行该线程钩子
		Runtime.getRuntime().addShutdownHook(shutdownThread);
		thread1.start();
		thread2.start();
		
		try {
			System.out.println("waitting for 3s...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}