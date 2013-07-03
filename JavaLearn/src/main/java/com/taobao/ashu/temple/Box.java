package com.taobao.ashu.temple;

public interface Box<Type> {
	public Type get();
	public void put(Type element);
}
