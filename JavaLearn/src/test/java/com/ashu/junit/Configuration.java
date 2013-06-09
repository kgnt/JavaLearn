package com.ashu.junit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	private Properties propertie;
	private FileInputStream inputFile;
	private FileOutputStream outputFile;

	/**
	 * initialize Configuration
	 */
	public Configuration() {
		propertie = new Properties();
	}

	/**
	 * initialize Configuration
	 * 
	 * @param filePath
	 *            properties file's path & name
	 */
	public Configuration(String filePath) {
		propertie = new Properties();
		try {
			inputFile = new FileInputStream(filePath);
			propertie.load(inputFile);
			inputFile.close();
		} catch (FileNotFoundException ex) {
			System.out
					.println("load properties file failed! maybe file not exist!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("load properties file failed!");
			ex.printStackTrace();
		}
	}

	/**
	 * overload, get value of key
	 * 
	 * @param key
	 *            key to get
	 * @return value of key
	 */
	public String getValue(String key) {
		if (propertie.containsKey(key)) {
			String value = propertie.getProperty(key);
			return value;
		} else
			return "";
	}

	/**
	 * overload, get value of key
	 * 
	 * @param fileName
	 *            properties file's path & name
	 * @param key
	 *            key to get
	 * @return value of key
	 */
	public String getValue(String fileName, String key) {
		try {
			String value = "";
			inputFile = new FileInputStream(fileName);
			propertie.load(inputFile);
			inputFile.close();
			if (propertie.containsKey(key)) {
				value = propertie.getProperty(key);
				return value;
			} else
				return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	/**
	 * clear all key add it's value in properties
	 */
	public void clear() {
		propertie.clear();
	}

	/**
	 * change or add a value of key, if key exist, change it to value, else add
	 * it as value
	 * 
	 * @param key
	 *            key to set
	 * @param value
	 *            value to set
	 */
	public void setValue(String key, String value) {
		propertie.setProperty(key, value);
	}

	/**
	 * save file, the file may not exist
	 * 
	 * @param fileName
	 *            file path & name
	 * @param description
	 *            file description
	 */
	public void saveFile(String fileName, String description) {
		try {
			outputFile = new FileOutputStream(fileName);
			propertie.store(outputFile, description);
			outputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
