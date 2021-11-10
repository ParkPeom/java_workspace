package com.codechobo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public FileInputStreamTest() {
	}
	public void start() {
		//byte단위로 파일 읽기
		try {
			File f = new File("C://javaFile","Diamond2.java");
			FileInputStream fis = new FileInputStream(f);
			//1byte
//			while(true) {
//				int data = fis.read();
//				if(data==-1) break;
//				System.out.print((char)data);
//			}
//			System.out.println("\n==========================");
			/*
			//한번에 읽어오기
			byte[] byteData = new byte[(int)f.length()];
			int cnt = fis.read(byteData, 0, byteData.length); //byteData 배열 0번부터 파일의 길이만큼
			System.out.println(new String(byteData));
			System.out.println("byte수 ->"+cnt);
			*/
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] allData = bis.readAllBytes(); // byte 배열로 받으면 while문 안돌려도됨
			System.out.println(new String(allData));
		}catch(FileNotFoundException e ) {
			System.out.println("파일이 존재하지 않아요");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileInputStreamTest().start();
	}
}
