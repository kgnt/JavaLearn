package com.taobao.ashu;

public class TestStringBuffer {

	public static void main(String[] args) {
//		StringBuffer a = new StringBuffer("a");
//		StringBuffer b = new StringBuffer("b");
//		String c = "ttt";
//
//		operate(a, b);
//		System.out.println("in main   , a=" + a + ", b=" + b);
//		System.out.println(c.replace('t', 'c'));
		
		String a = new String("a");
		StringBuffer b = new StringBuffer("b");

		a.replace('a', 'c');// 在replace方法中是new了一个新的字符串，修改的是新字符串，a本身还是"a"
		a = a.replace('a', 't');// 此时是将replace中修改好的字符串"t"赋给了a，a本身变为"t"

		b.append("t");// append是直接在b上进行修改，b变为"bt"
		System.out.println("a=" + a + ", b=" + b);// 输入为： a=t, b=bt

	}

	public static void operate(StringBuffer a, StringBuffer b) {
		a.append(b);
		b = a;
		System.out.println("in operate, a=" + a + ", b=" + b);
	 }

}
