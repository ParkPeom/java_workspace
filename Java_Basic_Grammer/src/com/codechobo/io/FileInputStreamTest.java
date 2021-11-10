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
		//byte������ ���� �б�
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
			//�ѹ��� �о����
			byte[] byteData = new byte[(int)f.length()];
			int cnt = fis.read(byteData, 0, byteData.length); //byteData �迭 0������ ������ ���̸�ŭ
			System.out.println(new String(byteData));
			System.out.println("byte�� ->"+cnt);
			*/
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] allData = bis.readAllBytes(); // byte �迭�� ������ while�� �ȵ�������
			System.out.println(new String(allData));
		}catch(FileNotFoundException e ) {
			System.out.println("������ �������� �ʾƿ�");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileInputStreamTest().start();
	}
}
