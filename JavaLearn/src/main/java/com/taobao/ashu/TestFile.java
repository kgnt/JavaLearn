package com.taobao.ashu;
import java.io.*;

public class TestFile {

	public TestFile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String separator = File.separator;
		String filename = "myfile.txt";
		String directory = "mydir1" + separator + "mydir2";
		
		File f = new File(directory, filename);
		if(f.exists()) {
			System.out.println("�ļ�����" + f.getAbsolutePath());
			System.out.println("�ļ���С�� " + f.length());
		} else {
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
