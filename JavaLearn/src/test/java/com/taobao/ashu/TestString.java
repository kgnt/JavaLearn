package com.taobao.ashu;

//import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestString {

	@Test
	public void test() {
		String value1 = "value1";
		String value2 = "value2";
		List<String> valueList = new ArrayList<String>();
		
		valueList.add(value1);
		valueList.add(value2);
		
		Iterator<String> iter = valueList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
	@Test
	public void testFloat() {
		float f = 0.5f;
		int i = 200;
		
		System.out.println(i / f);
		
		int t = 0;
		for(; t<10; t++) {
			
		}
		System.out.println(t);
	}
	
	@Test
	public void testDate() throws InterruptedException {
		Date a = new Date();
		System.out.println(a.getTime() / 1000);
		Thread.sleep(2000);
		System.out.println(a.getTime() / 1000);
		
		System.out.println(System.currentTimeMillis() / 1000);
	}
	
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value");
		map.put("key2", null);
		
		System.out.println(map.size());
		System.out.println(map.get("key2"));
	}
	
	@Test
	public void testList() {
		List<String> list = new ArrayList<String>();
		list.add(null);
		list.add("key");
		
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
	
	@Test
	public void testInteger() {
		Integer i = new Integer(10);
		System.out.println(new Integer(100 + i));
	}
	
	@Test
	public void testEmpty() {
		String cc = "";
		if(cc.isEmpty())
			System.out.println("haha");
	}
	
	@Test
	public void testNext() {
		System.out.println("a\n\n\nb");
		System.out.println(System.currentTimeMillis() / 1000);
	}
	
	private List<? extends Object> getResult() {
		List<Object> list = new ArrayList<Object>();
		list.add(new Integer(1));
		list.add(new Double(1));
		list.add("number");
		
		return list;
	}
	
	@Test
	public void testExtend() {
		List<? extends Object> returnList = getResult();
		for(Object n : returnList) {
			if(n instanceof Integer)
				System.out.print("Integer: ");
			if(n instanceof Double)
				System.out.print("Double: ");
			if(n instanceof String)
				System.out.print("String: ");
			System.out.println(n);
		}
	}
	
	private String vv = "old";
	private void changeVV() {
		vv = "new";
	}
	
	private void getVV() {
		System.out.println(vv);
	}

	@Test
	public void testVV() {
		System.out.println(vv);
		changeVV();
		getVV();
	}
	
	@Test
	public void testNull() {
		String a = null;
		if("".equals(a))
			System.out.println("a is null!");
	}
}
