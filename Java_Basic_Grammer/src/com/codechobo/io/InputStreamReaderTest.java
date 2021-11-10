package com.codechobo.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {

	}
	public void start() {
		// char���� �ֿܼ� �Է¹ޱ�
		InputStream ins = System.in;
		InputStreamReader isr = new InputStreamReader(System.in);
		
		try {
			System.out.print("�����Է�=");
			while(true) {
				/*1char�� �Է¹ޱ�
				int code = isr.read();
				if(code==13) break; // ���Ͱ� ���� 
				System.out.println(code+"-->"+ (char)code);
				*/
				//char�迭�� �ѹ��� �������� �Է¹ޱ�
				char[] inData = new char[5];
				int cnt = isr.read(inData);
				System.out.println(cnt+"-->"+ String.valueOf(inData, 0, cnt));
			}
		}catch(IOException i) {
			i.printStackTrace();
		} finally {
			try {
			isr.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new InputStreamReaderTest().start();
	}

}
