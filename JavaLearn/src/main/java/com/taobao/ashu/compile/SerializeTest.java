package com.taobao.ashu.compile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class SerializeTest {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		try {
			User user = new User("Alex", "Cheng");
			ObjectOutputStream output = new ObjectOutputStream(
					new FileOutputStream("src/main/resources/user.bin"));
			output.writeObject(user);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ObjectInputStream input = new ObjectInputStream(
					new FileInputStream("src/main/resources/user.bin"));
			User user = (User) input.readObject();
			System.out.println(user);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class User implements Serializable {

	private static final long serialVersionUID = -5046601675634205647L;
	private static String firstName = "defaultFirstName";
	private static String midName = "defaultMidName";

//	private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField(
//			firstName, String.class) };

	public User(String firstName, String midName) {
		User.firstName = firstName;
		User.midName = midName;
	}

	public String toString() {
		return firstName + " " + midName;
	}
	
	private void writeObject(ObjectOutputStream output) throws IOException {
	    output.defaultWriteObject();
	    output.writeUTF("add content: Hello World!");
	}
	private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
	    input.defaultReadObject();
	    String value = input.readUTF();
	    System.out.println(value);
	}  
}