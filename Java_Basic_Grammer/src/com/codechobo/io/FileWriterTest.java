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
			System.out.print("�����Է�=");
			String txt = br.readLine();
			
			File f = new File("C://javaFile","sample.txt");
			FileWriter fw = new FileWriter(f);
			fw.write(txt);
//			fw.close(); ��ü�� �ݾƹ��� 
			fw.flush(); 
			System.out.println("���Ϸ� ���� �Ϸ�");
			fw.write("\n�ٽþ���");
			fw.close();
			
		}catch(IOException e) {
			System.out.println("���� �б� ����");
		}
	}
	public static void main(String[] args) {
		new FileWriterTest().start();
	}
}
