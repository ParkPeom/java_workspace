package com.codechobo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTest {

	public FileWriterTest() {
	}
	public void start() {
		try {
			InputStreamReader isf = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isf);
			System.out.print("문자입력=");
			String txt = br.readLine();
			
			File f = new File("C://javaFile","sample.txt");
			FileWriter fw = new FileWriter(f);
			fw.write(txt);
//			fw.close(); 객체를 닫아버림 
			fw.flush(); 
			System.out.println("파일로 쓰기 완료");
			fw.write("\n다시쓰기");
			fw.close();
			
		}catch(IOException e) {
			System.out.println("문자 읽기 예외");
		}
	}
	public static void main(String[] args) {
		new FileWriterTest().start();
	}
}
