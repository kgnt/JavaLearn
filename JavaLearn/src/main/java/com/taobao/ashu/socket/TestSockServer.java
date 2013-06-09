package com.taobao.ashu.socket;

import java.io.*;
import java.net.*;

public class TestSockServer {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			ServerSocket server = new ServerSocket(5888);
			Socket client = server.accept();
			in = client.getInputStream();
			out = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			DataInputStream dis = new DataInputStream(in);
			String s = null;
			if ((s = dis.readUTF()) != null) {
				System.out.println(s);
				System.out.println("from: " + client.getInetAddress());
				System.out.println("Port: " + client.getPort());
			}
			dos.writeUTF("hi, i am server!");
			dis.close();
			dos.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}