package com.taobao.ashu.thread;

//一个类只有一把锁
public class ProducerConsumer {

	public static void main(String[] args) {
		int pCount = 3;
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss, pCount);
		for(int i = 0; i < pCount; i++)
		new Thread(p).start();//这里只是调用p的run方法，可以认为p只是个模版，
							//有多少线程，p的run就执行多少次，且run本身互不干扰
		new Thread(c).start();
	}

}

class WoTou {
	int id;

	WoTou(int id) {
		this.id = id;
	}

	public String toString() {
		return "第 " + String.format("%2d", id) + " 个窝头";
	}
}

class SyncStack {
	int index = 0;
	WoTou[] arrWT = new WoTou[6];

	public synchronized void push(WoTou wt) {
		while (index == arrWT.length)
			try {
				this.wait();// 获得执行权的线程去wait，wait一旦执行，线程丢锁
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.notifyAll();// 叫醒对当前方法有执行权且处于wait状态的一个/所有线程
		arrWT[index] = wt;
		System.out.println("生产了 " + arrWT[index]);
		index++;
	}

	public synchronized WoTou pop() {
		while (index == 0)
			try {
				this.wait();// 获得执行权的线程去wait
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.notifyAll();
		index--;
		System.out.println("消费了 " + arrWT[index]);
		return arrWT[index];
	}
}

class Producer implements Runnable {
	SyncStack ss = null;

	Producer(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			WoTou wt = new WoTou(i);
			ss.push(wt);
		}
	}
}

class Consumer implements Runnable {
	SyncStack ss = null;
	int pCount = 1;

	Consumer(SyncStack ss, int pCount) {
		this.ss = ss;
		this.pCount = pCount;
	}

	public void run() {
		for (int i = 0; i < 20 * 3; i++) {
			ss.pop();
		}
	}
}
