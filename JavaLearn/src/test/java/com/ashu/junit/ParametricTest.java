package com.ashu.junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParametricTest extends ParametricBase {

	private static String param1;
	@SuppressWarnings("unused")
	private static String param2;
	private static String cp = "1";

	public ParametricTest(String a, String b) {
		param1 = a;
		param2 = b;
	}

	@Before
	public void before() {
		if (!cp.equals(param1))
			System.out.println("in before, change copycount: " + param1);
		else
			System.out.println("in before, use copycount: " + param1);
		cp = param1;
	}

	@Test
	public void case1() throws Exception {
		System.out.println("running case1...");
	}

	@Test
	public void case2() throws Exception {
		System.out.println("running case2...");
	}
}
