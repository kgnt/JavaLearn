package com.taobao.ashu.thread;

import java.util.Date;

public class testInterrupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread = new MyThread();
		thread.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		thread.interrupt();
	}

}

class MyThread extends Thread {
	public void run() {
		while(true) {
			System.out.println("===" + new Date() + "===");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return;
			}
		}
	}
}