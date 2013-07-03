package com.taobao.ashu.temple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBox {

	public static void main(String[] args) {
		Integer i = 3;
		System.out.println(identity(i));

		Box<String> myBox1 = BoxImpl.make();
		// Box<String> myBox2 = BoxImpl.<String> make();

		myBox1.put("myBox1");
		System.out.println(myBox1.get());

		Box<String> sBox = new BoxImpl<String>();
		sBox.put("String element");
		System.out.println(sBox.get());

		Box<Number> nBox = new BoxImpl<Number>();
		nBox.put(30);
		System.out.println(nBox.get());

		List<ArrayList<Object>> ret = BoxImpl.getTerm();
		for (ArrayList<Object> l : ret) {
			for (Object r : l) {
				if (r instanceof String)
					System.out.println("get String: " + r);
				if (r instanceof Integer)
					System.out.println("get Integer: " + r);
			}
		}
	}

	public void unbox(Box<?> box) {
		System.out.println(box.get());
	}

	public void rebox(Box<?> box) {
		reboxHelper(box);
	}

	private <T> void reboxHelper(Box<T> box) {
		box.put(box.get());
	}

	public static <T> T identity(T arg) {
		return arg;
	}

	public <T extends Comparable<? super T>> void sort(List<T> list) {
		for (int i = 0; i < 1000000; i++)
			Collections.sort(list);
	}
}
