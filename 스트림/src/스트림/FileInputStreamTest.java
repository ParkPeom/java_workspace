package ½ºÆ®¸²;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamTest {
	
	public static void main(String[] args) {
		int i = 0;
		try {
			FileReader fis = new FileReader("input.txt");
			while( (i = fis.read()) != -1) {
				System.out.print((char)i);
			}
			System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
