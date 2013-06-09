package com.taobao.ashu.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import com.taobao.tair.ResultCode;
import com.taobao.tair.impl.DefaultTairManager;
import org.apache.log4j.Logger;

public class FileWriteThread {
	private static int threadCount = 10;
	private static File file = new File("a.txt");
	private static Thread[] threads = new Thread[threadCount];
	private static DefaultTairManager tairManager = new DefaultTairManager("",
			false);

	private static void initTair(DefaultTairManager tairManager, String name) {
		List<String> cs = new ArrayList<String>();
		cs.add("10.232.4.14:5008");
		cs.add("10.232.4.15:5008");
		tairManager.setConfigServerList(cs);
		tairManager.setGroupName("group_1");
		tairManager.setTimeout(2000);
		tairManager.setCompressionThreshold(1100000);
		tairManager.setCharset("UTF-8");
		tairManager.init();
	}

	public static void main(String[] args) {
		if (file.exists()) {
			file.delete();
		}
		 try {
		 if (!file.createNewFile() || file == null) {
		 System.err.println("create file failed!");
		 System.exit(-1);
		 }
		 } catch (IOException e) {
		 System.err.println("create file exception!");
		 e.printStackTrace();
		 System.exit(-1);
		 }

		initTair(tairManager, Thread.currentThread().getName());

		System.out.println(System.currentTimeMillis() / 1000);
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new FThread(file, tairManager),
					"thread_" + i);
			threads[i] = thread;
			threads[i].start();
		}

		boolean exitFlag = false;
		while (!exitFlag) {
			exitFlag = true;
			for (int i = 0; i < threadCount; i++) {
				if (threads[i].isAlive()) {
					exitFlag = false;
					break;
				}
			}
		}
		System.out.println(System.currentTimeMillis() / 1000);
		System.exit(0);
	}

}

class FThread implements Runnable {
	public static final Logger log = Logger.getLogger("FileWriteThread");
	private static BufferedWriter bw;
	private File file;
	private static DefaultTairManager tairManager;
	private static AtomicInteger num = new AtomicInteger(0);

	public FThread(File file, DefaultTairManager tairManager) {
		this.file = file;
		FThread.tairManager = tairManager;
	}

	public void run() {
		try {
			bw = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		for (int i = 0; i < 10000; i++) {
			ResultCode resultPut = tairManager.put(0, num + "", num);
//			num.addAndGet(1);
//			log.fatal("in " + Thread.currentThread().getName() + ", key=" + num.get() + ", bucket="
//					+ tairManager.getBucketOfKey(num) + ", rc=" + resultPut);
			doSth(resultPut);
		}
	}

	private static synchronized void doSth(ResultCode rc) {
		try {
			bw.write((System.currentTimeMillis() / 1000) + ", in "
					+ Thread.currentThread().getName() + ": key=" + num.get() + ", bucket="
					+ tairManager.getBucketOfKey(num) + ", rc=" + rc);
			bw.newLine();
			bw.flush();
			num.addAndGet(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void waitto(int millSecond) {
		try {
			Thread.sleep(millSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
