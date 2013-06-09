package com.taobao.ashu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;

public class TestFiles {

	protected static String testfile = "src/test/resources/test.properties";

	@Test
	public void testPath() {
		Properties propertie = new Properties();
		try {
			propertie.load(new FileInputStream(testfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		String testFile = propertie.getProperty("test_file");

		File file = new File(testFile);
		if (file.exists())
			System.out.println(file.getPath());
	}
}
