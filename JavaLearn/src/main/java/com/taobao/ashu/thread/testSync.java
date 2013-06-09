package com.taobao.ashu.thread;

public class testSync implements Runnable {

	Timer timer = new Timer();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSync test = new testSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());
	}

}

class Timer {
	private static int num = 0;

	// 锁定当前对象，整个过程是原子不可分的，执行过程不能被打断
	public synchronized void add(String name) {
		num++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {

		}
		System.out.println(name + "，你是第" + num + "个使用timer的线程");
	}
}