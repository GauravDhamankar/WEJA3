package com.jspiders.serializationanddesirialization.desrialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.serializationanddesirialization.object.User;

public class Desirialization {
 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("File.txt");
		
		if (file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			User user = (User) objectInputStream.readObject();
			System.out.println(user);
			System.out.println("Object is read from the file");
			objectInputStream.close();
			fileInputStream.close();
		} else {
			System.out.println("File does not exists.");
		}
	}
}
