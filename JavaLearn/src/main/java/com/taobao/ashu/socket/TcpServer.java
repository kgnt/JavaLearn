package com.taobao.ashu.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class TcpServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(43683);
		Socket s = ss.accept();//连过来的某个client，阻塞式的
		System.out.println("in TcpServer: a client connected!");
		DataInputStream dis = new DataInputStream(s.getInputStream());//拿到输入管道
		System.out.println("in TcpServer: " + dis.readUTF());//阻塞式的
	}

}
