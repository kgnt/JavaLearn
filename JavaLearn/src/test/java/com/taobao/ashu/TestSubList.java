package com.taobao.ashu;

import java.util.ArrayList;
import java.util.List;

public class TestSubList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> all = new ArrayList<String>();
		all.add("a");
		all.add("b");
		all.add("c");
		all.add("d");
		all.add("e");
		List<String> sub = all.subList(0, all.size()-1);
		for(String str : sub)
			System.out.println(str);
	}

}
