package com.taobao.ashu;

public class testString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.ensureCapacity(1024);
		System.out.println(str.length());
		str.append('d');
		System.out.println(str.length());
		
		System.out.println("t=" + String.format("%4d", 12));
	}

}
