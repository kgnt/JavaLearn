package com.ashu.junit;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStatic {
	
	private static String param = "param";
	
	@Test
	public void case1() {
		
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("in before class, param=" + param);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("in after class, param=" + param);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

}
