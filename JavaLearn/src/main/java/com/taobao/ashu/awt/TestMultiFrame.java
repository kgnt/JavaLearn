package com.taobao.ashu.awt;

import java.awt.Color;
import java.awt.Frame;

public class TestMultiFrame {

	public static void main(String[] args) {
		MyFrame f1 = new MyFrame(100, 100, 300, 200, Color.BLACK);
		MyFrame f2 = new MyFrame(400, 100, 300, 200, Color.YELLOW);
		MyFrame f3 = new MyFrame(100, 300, 300, 200, Color.GREEN);
		MyFrame f4 = new MyFrame(400, 300, 300, 200, Color.MAGENTA);
	}

}

class MyFrame extends Frame {
	static int id = 0;
	MyFrame(int x, int y, int w, int h, Color color) {
		super("MyFrame: " + (++id));
		setBackground(color);
		setLayout(null);// 设置布局管理器为空
		setBounds(x, y, w, h);
		setVisible(true);
	}
}