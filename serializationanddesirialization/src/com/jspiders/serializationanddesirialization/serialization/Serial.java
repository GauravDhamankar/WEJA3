package com.jspiders.serializationanddesirialization.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationanddesirialization.object.User;

public class Serial {

	public static void main(String[] args) throws IOException {
		File file = new File("File.txt");
		
		if (file.exists()) {
			System.out.println("File is already exists.");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new User(1,"Ramesh","ramesh@gmail.com","Ramesh@123"));
			System.out.println("object is wriiten to the file");
			objectOutputStream.close();
			fileOutputStream.close();
		} else {
			file.createNewFile();
			System.out.println("New file is created.");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new User(1,"Ramesh","ramesh@gmail.com","Ramesh@123"));
			System.out.println("Object is written to the file");
			objectOutputStream.close();
			fileOutputStream.close();
		}
	}
}
