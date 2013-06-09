package com.taobao.ashu;
import java.util.*;

public class CollectionTest {

	public CollectionTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection c = new ArrayList();//��������ָ��������󡣽����������¸�c��ʼ��Ϊ�����
		c.add("hello");
		c.add(new Integer(100));
		System.out.println(c.size());
		System.out.println(c);//�൱�ڵ�����c.toString()

	}

}
