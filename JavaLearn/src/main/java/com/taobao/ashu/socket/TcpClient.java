package com.taobao.ashu.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class TcpClient {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1", 43683);//new时就已经去连了
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());//拿到输出管道
		dos.writeUTF("in TcpClient: hello server!");
		dos.close();
		s.close();
	}

}
