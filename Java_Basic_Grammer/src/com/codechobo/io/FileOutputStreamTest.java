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
		//�ֿܼ��� ������ ���ڿ��� �Է¹޾� ���Ϸ� ���� C://javaFile/test.txt
		System.out.print("���ڿ��Է�=");
		String str = br.readLine(); // ���ϱ��
	
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
 