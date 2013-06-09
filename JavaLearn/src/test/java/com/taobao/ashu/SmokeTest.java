package com.taobao.ashu;

import org.junit.*;
import org.databene.contiperf.*;
import org.databene.contiperf.junit.ContiPerfRule;

public class SmokeTest {

    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Test
    @PerfTest(invocations = 2)
//    @Required(max = 1200, average = 250)
    public void test1() throws Exception {
        Thread.sleep(200);
        System.out.println("test1");
    }
    
    @Test
    @PerfTest(invocations = 2)
    public void test2() throws Exception {
        Thread.sleep(200);
        System.out.println("test2");
    }

}