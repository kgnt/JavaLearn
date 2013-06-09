package com.taobao.ashu.socket;

import java.net.*;
import java.io.*;

public class TestServer {
	public static void main(String args[]) {
		try {		
			ServerSocket s = new ServerSocket(8888);
			while (true) {
				Socket s1 = s.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);//server往client写
				dos.writeUTF("Hello," + s1.getInetAddress() + 
						"port#" +s1.getPort() + "  bye-bye!");
				dos.close();
				s1.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("程序运行出错:" + e);			
		}
	}
}