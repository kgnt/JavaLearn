package com.taobao.ashu;
import java.util.*;

public class HashSetTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a"); s1.add("b"); s1.add("c");
		s2.add("a"); s2.add("b"); s2.add("d");
		
		Set f1 = new HashSet(s1);
		f1.retainAll(s2);//�󽻼�
		Set f2 = new HashSet(s1);
		f2.addAll(s2);//�󲢼�
		
		System.out.println(f1);
		System.out.println(f2);

	}

}
