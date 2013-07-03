package com.taobao.ashu.temple;

import java.util.ArrayList;
import java.util.List;

public class BoxImpl<Type> implements Box<Type> {
	
	private Type element;
	
	public BoxImpl() {
	}
	
	@Override
	public Type get() {
		return this.element;
	}

	@Override
	public void put(Type element) {
		this.element = element;
	}

	public static <V> Box<V> make() {
        return new BoxImpl<V>();
    }
	
	public static List<ArrayList<Object>> getTerm() {
		List<ArrayList<Object>> ret = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> r1 = new ArrayList<Object>();
		ArrayList<Object> r2 = new ArrayList<Object>();
		
		r1.add(new String("element"));
		r2.add(1);
		
		ret.add(r1);
		ret.add(r2);
		return ret;
	}

}
