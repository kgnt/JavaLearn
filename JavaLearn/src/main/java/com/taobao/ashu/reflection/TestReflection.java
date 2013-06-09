package com.taobao.ashu.reflection;

import java.lang.reflect.InvocationTargetException;

public class TestReflection {
	
	protected String name = "TestReflection";

	public static void main(String[] args) {
//		new TestRefection().execute();
//		new Another().invokeTestReflection();
		TestReflectionExtend tre = new TestReflectionExtend();
		tre.printName();
	}
	
	public void execute() {
		try {
			TestReflection.class.getMethod("printName").invoke(this);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public void printName() {
		System.out.println("TestRefection");
	}

}


class Another {
	
	public Another() {
	}
	
	public void invokeTestReflection() {
		new TestReflection().execute();
	}
}