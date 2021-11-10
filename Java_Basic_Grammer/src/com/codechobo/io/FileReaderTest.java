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
			File f = new File("C://javaFile","Diamond2.java"); // ������ ���ϸ� 
			FileReader fr = new FileReader(f);
			/* ���ѹݺ����� �о����
			 * while(true) {
				int inData = fr.read();
				if(inData==-1)break; // �о���°� ������ �������� 
				System.out.print((char)inData);
			}*/
			/* �ѹ��� �� �б�
			char[] inData = new char[(int)f.length()];
				fr.read(inData, 0, inData.length);
				System.out.println(String.valueOf(inData));
			*/
			// ���پ�
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				System.out.println(str); // ln���� ���Ͱ� ����ȵ� 
			}
		}catch(FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			System.out.println("�����б⿡�� �߻�");
		}
	}
	public static void main(String[] args) {
		new FileReaderTest().start();
		
	}
}
