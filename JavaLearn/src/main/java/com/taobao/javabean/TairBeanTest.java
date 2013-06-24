package com.taobao.javabean;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.taobao.tair.impl.mc.MultiClusterTairManager;

public class TairBeanTest {

	private static MultiClusterTairManager tairManager;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"tair.xml");
		tairManager = (MultiClusterTairManager) appContext
				.getBean("tairManager");

		System.out.println(tairManager.put(0, "key", "value"));
		System.exit(0);
	}

}
