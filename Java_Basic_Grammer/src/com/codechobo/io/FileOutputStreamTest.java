package com.codechobo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOutputStreamTest {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public FileOutputStreamTest() {
		
	}
	public void start() {
		try {
		//콘솔에서 한줄의 문자열을 입력받아 파일로 쓰기 C://javaFile/test.txt
		System.out.print("문자열입력=");
		String str = br.readLine(); // 파일기록
	
		File f = new File("C://javaFile/","test.txt");
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(str.getBytes());
		fos.flush();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileOutputStreamTest().start();
	}

}
 