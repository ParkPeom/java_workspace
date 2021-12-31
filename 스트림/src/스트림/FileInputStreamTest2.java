package ½ºÆ®¸²;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try (FileInputStream fis = new FileInputStream("input2.txt")) {
			byte[] bs = new byte[10];
			int i;
			while((i = fis.read(bs)) != -1) {
				for(byte b : bs) {
					System.out.println((char)b);
				}
			}
			
		} 
	}
}
