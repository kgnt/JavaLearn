package com.taobao.ashu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	FileInputStream fis;
	byte[] buf = new byte[1024];
	FileOutputStream fos;
	int len = 0;

	public static void main(String[] args) {

		FileUtil fu = new FileUtil();
		// String srcFile="F:/test.properties";
		// String desFile="F:/test.txt";
		// String srcFile="F:/B-初步.ppt"; //java.io.FileNotFoundException，为啥
		// 不支持ppt呢？
		// String srcFile="F:/部署文档.doc"; //中文 可以访问,word 版本要一致，不然文件打不开
		// String srcFile="F:/t.doc";
		String srcFile = "F:/t.ppt"; // 支持ppt,但是打不开文件
		String desFile = "F:/test.ppt";
		fu.init(srcFile, desFile);

		fu.new ReadFileThread().start();
		fu.new WriteFileThread().start();
	}

	/**
	 * 初始化，输进流，输出流
	 * 
	 * @param srcFile
	 *            读取的文件名
	 * @param desFile
	 *            写进的文件名
	 */
	void init(String srcFile, String desFile) {
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(desFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 读取一个文件到buf数组中，先读一次，再wait()
	 * 
	 * @author Administrator
	 * 
	 */
	class ReadFileThread extends Thread {
		public void run() {
			try {

				synchronized (this) {

					if (len != 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					len = fis.read(buf);
					notify(); // 唤醒写进线程
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

			}
		}
	}

	/**
	 * 写进另一个文件，假如读取的长度len!=0,就把buf的内容写进到另一个文件，并且把len=0;换醒读取线程
	 * 
	 * @author Administrator
	 * 
	 */
	class WriteFileThread extends Thread {
		public void run() {
			synchronized (this) {
				if (len == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					fos.write(buf, 0, len);
				} catch (IOException e) {
					e.printStackTrace();
				}
				len = 0;
				notify();
			}
		}
	}
}
