package com.taobao.ashu;

public class SubExceptionTest {

	public static void main(String[] args) {
		SubThrow st = new SubThrow("fail");
		try {
			System.out.println(st.getName());
		} catch (SubException e) {
			e.printStackTrace();
		}
	}

}

class SubException extends Exception {
	private static final long serialVersionUID = -3532696204050722427L;
	private String errMsg;

	public SubException(String errMsg) {
		this.errMsg = errMsg;
	}

	public void printStackTrace() {
		printStackTrace(System.err);
		System.out.print(": " + errMsg);
	}
}

class SubThrow {
	private String name;

	public SubThrow(String name) {
		this.name = name;
	}

	public String getName() throws SubException {
		if (name.equals("fail"))
			throw new SubException("name equals fail!");
		return name;
	}
}