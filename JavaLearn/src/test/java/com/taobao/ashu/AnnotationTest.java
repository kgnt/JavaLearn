package com.taobao.ashu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class AnnotationTest {

	@Rule
	public TestName testname = new TestName();

	@DataPoint
	public static String dPoint = "I love JUnit!";
	@DataPoint
	public static String dPoint2 = "I love JUnit, too!";
	@DataPoint
	public static int dPoint3 = 3;

	// 测试@BeforeClass批注，在整个测试类中只运行一次，有别于@Before。
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("BeforeClass");
	}

	// 测试@Before批注，在每个测试方法运行前执行该方法。
	@Before
	public void testBefore() {
		System.out.println("Before");
	}

	// 测试@Test批注。
	@Test
	public void testMethod() {
		Assert.assertEquals("testMethod", testname.getMethodName());
		System.out.println("testMethod");
	}

	// 测试@Theory批注。
	@Theory
	public void testDataPoint(String interests) {
		// interests必须是I love JUnit!，否则跳过该测试函数。
		// interests must be I love JUnit!, or skip the test function.
//		assumeThat(interests, is("I love JUnit!"));
//		Assert.assertEquals("testDataPoint", testname.getMethodName());
		System.out.println("testDataPoint" + ": " + interests);
	}

	// 测试@Ignore批注
	@Ignore
	@Test
	public void testIgnore() {
		Assert.assertEquals("testIgnore", testname.getMethodName());
		System.out.println("testIgnore");
	}

	// 测试@After批注，每个test方法执行完成后运行此方法
	@After
	public void testAfter() {
		System.out.println("After");
	}

	// 测试@AfterClass批注，在整个测试类中只运行一次，有别于@After
	@AfterClass
	public static void testAfterClass() {
		System.out.println("AfterClass");
	}
}
