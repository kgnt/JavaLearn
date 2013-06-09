package com.taobao.ashu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSon extends TestFather {

	@Test
	public void test() {
		System.out.println("test case in son!");
	}
	
	@BeforeClass
	public static void SonBeforeClass() {
		System.out.println("SonBeforeClass!");
	}
	
	@AfterClass
	public static void SonAfterClass() {
		System.out.println("SonAfterClass!");
	}
	
	@Before
	public void SonBefore() {
		System.out.println("SonBefore!");
	}
	
	@After
	public void SonAfter() {
		System.out.println("SonAfter!");
	}

}
