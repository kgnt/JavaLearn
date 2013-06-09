package com.taobao.ashu;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class Son extends Father {

	@Rule
    public ContiPerfRule i = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 2)
	public void testCase() {
//		System.out.println("Method name: " + name.getMethodName());
//		System.out.println("Method name: " + getFunctionName());
//		System.out.println("Class name: " + getClassName());
		System.out.println("TestCase: " + name.getMethodName());
	}
	
	@Before
	public void extendBefore() {
		System.out.println("Son: before");
	}
	
	public void sonAfter() {
		System.out.println("Son: after");
	}
	
	@BeforeClass
	public static void extendBeforeClass() {
		System.out.println("Son: beforeClass");
	}
	
	@AfterClass
	public static void extendAfterClass() {
		System.out.println("Son: afterClass");
	}
}
