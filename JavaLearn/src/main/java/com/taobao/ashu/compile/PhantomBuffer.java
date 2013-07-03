package com.taobao.ashu.compile;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomBuffer {
	private byte[] data = new byte[0];
	private ReferenceQueue<byte[]> queue = new ReferenceQueue<byte[]>();
	private PhantomReference<byte[]> ref = new PhantomReference<byte[]>(data,
			queue);

	public byte[] get(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Wrong buffer size");
		}
		if (data.length < size) {
			data = null;
			System.gc(); // 强制运行垃圾回收器
			try {
				queue.remove(); // 该方法会阻塞直到队列非空
				ref.clear(); // 幽灵引用不会自动清空，要手动运行
				ref = null;
				data = new byte[size];
				ref = new PhantomReference<byte[]>(data, queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
