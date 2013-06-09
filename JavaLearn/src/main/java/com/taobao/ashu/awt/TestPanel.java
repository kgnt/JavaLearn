package com.taobao.ashu.awt;

import java.awt.*;

public class TestPanel {

	public static void main(String[] args) {
		Frame f = new Frame("Java Frame with Panel");
		Panel p = new Panel(null);
		f.setLayout(null);
		f.setBounds(300, 200, 400, 300);
		f.setBackground(new Color(100, 200, 30));
		p.setBounds(150, 100, 300, 225);// 在Frame里的相对坐标
		p.setBackground(new Color(30, 30, 200));
		f.add(p);
		f.setVisible(true);
	}

}
