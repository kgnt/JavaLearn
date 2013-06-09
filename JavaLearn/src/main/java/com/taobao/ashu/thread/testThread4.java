package com.taobao.ashu.thread;

public class testThread4 {

	public static void main(String[] args) {

		Runner4 r = new Runner4();
		Thread t = new Thread(r);
		t.start();
		for(int i = 0; i < 100000; i++) {
			if(i % 10000 == 0 && i > 0)
				System.out.println("in main thread i=" + i);
		}
		
		System.out.println("main thread is over!");
		r.shutDown();
	}

}


class Runner4 implements Runnable {
	private boolean flag = true;

	public void run() {
		int i = 0;
		while(flag) {
			System.out.println(" " + i++);
		}
	}
	
	public void shutDown() {
		flag = false;
	}
	
}