package com.taobao.ashu;

public class testEnum {

	public testEnum() {
		// TODO Auto-generated constructor stub
	}

	public enum MyColor {
		red, green, blue
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyColor m = MyColor.red;
		switch (m) {
		case red:
			System.out.println("red");
			break;
		case green:
			System.out.println("green");
			break;
		case blue:
			System.out.println("blue");
			break;
		default:
			System.out.println("default");
			break;
		}

	}

}
