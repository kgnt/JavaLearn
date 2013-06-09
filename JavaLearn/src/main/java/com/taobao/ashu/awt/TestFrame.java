package com.taobao.ashu.awt;

import java.awt.*;

public class TestFrame {

	public static void main(String[] args) {

		Frame f = new Frame("My first Test");
		f.setLocation(300, 300);
		f.setSize(400, 300);
		f.setBackground(Color.blue);
		f.setResizable(false);
		f.setVisible(true);
	}

}
