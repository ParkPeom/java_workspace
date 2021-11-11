package com.codechobo.io.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedRedaerTest {

	public BufferedRedaerTest() {
	}
	public void start() {
		File f = new File("C:\\javaFile","love.txt");
		FileReader fr;
		
		try {
		    fr = new FileReader(f);
			char[] ch = new char[(int)fr.read()];
			fr.read(ch, 0 , ch.length);
			System.out.println(String.valueOf(ch));
		} catch(FileNotFoundException e) {
				System.out.println("파일을 찾을수 없습니다.");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		new BufferedRedaerTest().start();
	}
}
