package com.taobao.ashu;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestTemplate {

	public void inspect(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	@Test
	public void test() {
		List<String> strs = new ArrayList<String>();
		inspect(strs);
	}
}
