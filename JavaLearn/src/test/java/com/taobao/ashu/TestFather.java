package com.taobao.ashu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestFather {

	@BeforeClass
	public static void FatherBeforeClass() {
		System.out.println("FatherBeforeClass!");
	}
	
	@AfterClass
	public static void FatherAfterClass() {
		System.out.println("FatherAfterClass!");
	}
	
	@Before
	public void FatherBefore() {
		System.out.println("FatherBefore!");
	}
	
	@After
	public void FatherAfter() {
		System.out.println("FatherAfter!");
	}
}
