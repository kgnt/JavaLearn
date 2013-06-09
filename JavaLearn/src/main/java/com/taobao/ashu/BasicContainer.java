package com.taobao.ashu;

import java.util.*;

public class BasicContainer {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection c = new HashSet();
		c.add("hello");
		c.add(new Name("f1", "l1"));
		c.add(new Integer(100));
		c.add("hello");
		c.remove(new Integer(100));
		System.out.println(c.remove(new Name("f1", "l1")));
		System.out.println(c);

	}

}

@SuppressWarnings("rawtypes")
class Name implements Comparable{
	private String firstName, lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return firstName + lastName;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Name) {
			Name name = (Name) obj;
			return (firstName.equals(name.firstName) && lastName
					.equals(name.lastName));
		}
		return super.equals(obj);
	}
	
	public int hashCode() {
		return firstName.hashCode();
	}
	
	public int compareTo(Object o) {
		if(o instanceof Name) {
			Name n = (Name)o;
			int lastCmp = lastName.compareTo(n.lastName);
			return (lastCmp != 0 ? lastCmp:firstName.compareTo(n.firstName));
		}
		return -1;
	}
}