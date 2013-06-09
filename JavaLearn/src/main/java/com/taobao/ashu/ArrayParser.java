package com.taobao.ashu;

public class ArrayParser {

	public ArrayParser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1,2;3,4,5;6,7,8";
		String[] sFirst = s.split(";");
		double[][] d = new double[sFirst.length][];
		for(int i = 0; i < sFirst.length; i++) {
//			System.out.println(sFirst[i]);
			String[] sSecond = sFirst[i].split(",");
			d[i] = new double[sSecond.length];
			for(int j = 0; j < sSecond.length; j++) {
				d[i][j] = Double.parseDouble(sSecond[j]);
//				System.out.println(d[i][j]);
			}
		}
		
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}

	}

}
