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
		System.out.println(filename.getName());//返回文件或目录名
		tree(filename, 1);
	}
	
	private static void tree(File f, int level) {
		String preStr = "";
		for(int i = 0; i < level; i++) {
			preStr += "    ";
		}
		File[] childs = f.listFiles();//f的所有子文件及子目录
		for(int i = 0; i < childs.length; i++) {
			System.out.println(preStr + childs[i].getName());//打印该文件或目录的名字
			if(childs[i].isDirectory())
				tree(childs[i], level + 1);
		}
	}

}
