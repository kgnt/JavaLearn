package com.taobao.ashu.compile;

import java.lang.ref.SoftReference;

public class ImageData {
	private String path = "";
	private SoftReference<byte[]> dataRef;

	public ImageData(String path) {
		this.path = path;
		dataRef = new SoftReference<byte[]>(new byte[0]);
	}

	private byte[] readImage() {
		return new byte[1024 * 1024]; // 省略了读取文件的操作
	}

	public byte[] getData() {
		byte[] dataArray = dataRef.get();
		if (dataArray == null || dataArray.length == 0) {
			dataArray = readImage();
			dataRef = new SoftReference<byte[]>(dataArray);
		}
		return dataArray;
	}
}
