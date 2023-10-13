package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharStreamReadDemo2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Demo.txt");
		
		if (file.exists()) {
			
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			
			System.out.println("Data is fethed from the file");
			scanner.close();
		} else {
			System.out.println("File does not exists.");
		}
	}
}
