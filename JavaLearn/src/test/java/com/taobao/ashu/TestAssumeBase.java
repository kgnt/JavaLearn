package com.taobao.ashu;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeThat;

public class TestAssumeBase {

	protected void except() {
		assumeThat(1, not(1));
	}
	
}
