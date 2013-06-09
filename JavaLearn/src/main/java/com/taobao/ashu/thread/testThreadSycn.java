package com.taobao.ashu.thread;

public class testThreadSycn {
	
	public static  boolean flag = false;

	public static void main(String[] args) {
		
		Thread t = new Thread(new TestThread());
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;
		System.out.println("testThreadSycn finished!");
	}

}


class TestThread implements Runnable {
	
	private boolean waitFlag = true;

	public void run() {
		while (waitFlag) {
			if(testThreadSycn.flag) {
				System.out.println("testThreadSycn.flag: " + testThreadSycn.flag);
				waitFlag = false;
			}
		}
		System.out.println("TestThread finished!");
	}
	
}