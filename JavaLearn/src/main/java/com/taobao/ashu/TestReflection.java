package com.taobao.ashu;

import java.lang.reflect.InvocationTargetException;

public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, SecurityException,
			InvocationTargetException, NoSuchMethodException {

		Class<?> relativeClass = Class.forName("com.taobao.ashu.Relative");
		Object relativeFather = relativeClass.newInstance();
		Object relativeMother = relativeClass.newInstance();
		relativeClass.getMethod("setName", String.class).invoke(relativeFather,
				"father");
		relativeClass.getMethod("setName", String.class).invoke(relativeMother,
				"mother");

		Class<?> personClass = Class.forName("com.taobao.ashu.Person");
		Object personObject = personClass.newInstance();

		Class<?> relativeClassArray = Class
				.forName(new Relative[] {}.getClass().getName());
		Object[] temp = (Object[]) java.lang.reflect.Array.newInstance(
				relativeClass, 2);
		temp[0] = relativeFather;
		temp[1] = relativeMother;

		personClass.getMethod(
				"setParents",
				java.lang.reflect.Array.newInstance(relativeClass, 2)
						.getClass()).invoke(personObject,
				relativeClassArray.cast(temp));

		personClass.getMethod("getParents").invoke(personObject);
	}

}

class Person {
	private Relative[] parents;

	public void getParents() {
		for (Relative r : parents)
			r.getName();
	}

	public void setParents(Relative[] parents) {
		this.parents = parents;
	}
}

class Relative {
	private String name;

	public void getName() {
		System.out.println(name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
