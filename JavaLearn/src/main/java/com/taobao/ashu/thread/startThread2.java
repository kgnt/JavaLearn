package com.taobao.ashu.thread;

public class startThread2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner r = new Runner();
		r.start();

		for(int i = 0; i < 100; i++) {
			System.out.println("main thread: " + i);
		}
	}

}

class Runner extends Thread {
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("son thread: " + i);
		}
	}
}
