package com.taobao.ashu;
import java.io.*;

public class FileList {

	public FileList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File filename = new File("f:/music");
		System.out.println(filename.getName());//�����ļ���Ŀ¼��
		tree(filename, 1);
	}
	
	private static void tree(File f, int level) {
		String preStr = "";
		for(int i = 0; i < level; i++) {
			preStr += "    ";
		}
		File[] childs = f.listFiles();//f���������ļ�����Ŀ¼
		for(int i = 0; i < childs.length; i++) {
			System.out.println(preStr + childs[i].getName());//��ӡ���ļ���Ŀ¼������
			if(childs[i].isDirectory())
				tree(childs[i], level + 1);
		}
	}

}
