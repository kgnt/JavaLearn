package com.ashu.junit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegularExpressionTest {
	private static String zipRegEx = "^\\d{5}([\\-]\\d{4})?$";
	// private static String zipRegEx = "2211";
	private static Pattern pattern;

	@Before
	public void setUpBeforeClass() throws Exception {
		pattern = Pattern.compile(zipRegEx);
	}

	@Test(expected = IllegalStateException.class)
	public void verifyZipCodeNoMatch() throws Exception {
		Matcher mt = pattern.matcher("2211");
		assertFalse("Pattern did validate zip code", mt.matches());
		mt.group(2);
	}

	@Test(timeout = 1)
	public void verifyFastZipCodeMatch() throws Exception {
		Pattern pattern = Pattern.compile("^\\d{5}([\\-]\\d{4})?$");
		assertTrue("Pattern did not validate zip code", pattern.matcher("22011").matches());
	}
}
