package com.taobao.ashu.socket;

import java.net.*;
import java.io.*;

public class TestSockClient {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("10.7.14.72", 5888);
			
			Thread comThread = new Thread(new Communicate(socket));
			comThread.start();

			waitto(7);
			comThread.stop();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void waitto(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Communicate implements Runnable {

	private Socket socket;

	public Communicate(Socket socket) {
		this.socket = socket;
		System.out.println("start communicate with server...");
	}

	@SuppressWarnings("deprecation")
	public void run() {
		try {
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String strFromClient = null;

			while (true) {
				try {
					strFromClient = din.readUTF();
					if (strFromClient != null) {
						System.out.println(strFromClient);
//						System.out.println("client ip:   "
//								+ socket.getInetAddress());
//						System.out.println("client port: " + socket.getPort());
					}
//					TestSockClient.waitto(1);
				} catch (EOFException e) {
					// e.printStackTrace();
				} finally {
//					din.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Thread.currentThread().stop();
		}
	}

}
