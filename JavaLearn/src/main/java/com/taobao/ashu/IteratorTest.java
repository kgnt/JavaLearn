package com.taobao.ashu;
import java.util.*;

public class IteratorTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection c = new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("!");
		
		Iterator<ArrayList> iter = c.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
