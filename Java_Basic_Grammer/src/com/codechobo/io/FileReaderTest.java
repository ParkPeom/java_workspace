package com.codechobo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
	
	}
	public void start() {
		try {
			File f = new File("C://javaFile","Diamond2.java"); // 절대경로 파일명 
			FileReader fr = new FileReader(f);
			/* 무한반복으로 읽어오기
			 * while(true) {
				int inData = fr.read();
				if(inData==-1)break; // 읽어오는게 없으면 빠져나감 
				System.out.print((char)inData);
			}*/
			/* 한번에 다 읽기
			char[] inData = new char[(int)f.length()];
				fr.read(inData, 0, inData.length);
				System.out.println(String.valueOf(inData));
			*/
			// 한줄씩
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				System.out.println(str); // ln으로 엔터가 실행안됨 
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException e) {
			System.out.println("파일읽기에러 발생");
		}
	}
	public static void main(String[] args) {
		new FileReaderTest().start();
		
	}
}
