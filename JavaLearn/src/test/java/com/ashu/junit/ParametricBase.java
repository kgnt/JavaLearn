package com.ashu.junit;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.Parameterized.Parameters;

public class ParametricBase {

	protected String caseIdentifier = "";
	protected static String properties = "src/test/resources/test.properties";

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection copyCount() {
		Configuration rc = new Configuration(properties);
		String cpTemp = rc.getValue("copycount");
		String[] strTemp = cpTemp.split("\\,");
		List cpList = Arrays.asList(strTemp);
//		System.out.println(cpList);

		Object[][] tt = new Object[cpList.size()][2];
		for(int i = 0; i < cpList.size(); i++) {
			tt[i][0] = cpList.get(i);
			tt[i][1] = cpList.get(i);
		}

		return Arrays.asList(tt);
	}

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		protected void starting(Description d) {
			caseIdentifier = d.getClassName() + "." + d.getMethodName();
		}

		protected void succeeded(Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
//			System.out.println("succeeded: " + caseIdentifier);
		}

		protected void failed(Throwable e, Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
		}

		protected void finished(Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			System.out.println("finished: " + caseIdentifier);
			System.out.println("");
		}

	};
}
