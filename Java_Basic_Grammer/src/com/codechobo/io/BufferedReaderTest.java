package com.codechobo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {

	}
	public void start() {
		//���ۿ� ���ڴ��� �Է¹��� �����͸� ������ ���پ� �Է��� �� �ִ� Ŭ�����̴�.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			while(true) {
				System.out.print("�Է�=");
				String txt = br.readLine();
				System.out.println("txt=>"+ txt);
			}
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new BufferedReaderTest().start();
	}
}
