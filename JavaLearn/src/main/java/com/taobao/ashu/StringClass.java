package com.taobao.ashu;

public class StringClass {

	public StringClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "sunjavahpjavaokjavajjavahahajavajavagoodjava";
		int count = 0;
		int pos = s.indexOf("java");
		while(pos != -1) {
			count++;
			s = s.substring(pos + 4);
			pos = s.indexOf("java");
		}
		System.out.println(count);
		System.out.println(Integer.toBinaryString(count));
	}

}
