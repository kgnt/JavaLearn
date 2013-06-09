package com.taobao.ashu.thread;
//synchronized只能保证在同一时间，只有一个线程能访问锁住的方法，
//不能阻止别的线程访问别的方法，也不能保证方法体内部的变量不变
//（在别的方法中仍可以改变变量值，且可以反映在锁住的方法中）
//要想保证元素的互斥性，必须把所有调用它的方法都上锁。锁住之后变量只受本方法影响，且
//哪个被锁的方法先执行，则一定得执行完毕，才会让之后的上锁方法执行——锁只有一把
//无论有多少个线程，加锁的方法在同一时间只能有一个线程能获得锁执行，因此锁住的方法
//是串行执行的

public class interviewSync implements Runnable {
	public int b = 100;
	public synchronized void m1() {
		System.out.println("enter m1!");
		b = 1000;
		waitto(5000);
		System.out.println("in m1, b=" + b);
	}
	public synchronized void m2() {
		System.out.println("enter m2!");
		waitto(2500);
		b = 2000;
		System.out.println("in m2, b=" + b);
	}
	public void run() {
		m1();
	}
	
	public static void main(String[] args) {
		interviewSync is1 = new interviewSync();
		Thread t = new Thread(is1);
		t.start();
		waitto(1);
		is1.m2();
		System.out.println(is1.b);
	}
	
	public static void waitto(int milsecond) {
		try {
			Thread.sleep(milsecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
