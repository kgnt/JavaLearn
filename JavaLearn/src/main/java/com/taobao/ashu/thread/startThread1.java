package com.taobao.ashu.thread;

public class startThread1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner r = new Runner();
//		r.run();
		Thread t = new Thread(r);//��̬��ʵ���õ���Runner��run
		t.start();//��ʼ����Runner1��run����������ִ���꣬��������Ĵ���
		
		for(int i = 0; i < 100; i++) {
			System.out.println("main thread: " + i);
		}

	}

	static class Runner implements Runnable {
		public void run() {
			for(int i = 0; i < 100; i++) {
				System.out.println("son thread: " + i);
			}
		}
	}
}
