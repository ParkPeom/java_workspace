package com.codechobo.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {

	}
	public void start() {
		// char단위 콘솔에 입력받기
		InputStream ins = System.in;
		InputStreamReader isr = new InputStreamReader(System.in);
		
		try {
			System.out.print("문자입력=");
			while(true) {
				/*1char를 입력받기
				int code = isr.read();
				if(code==13) break; // 엔터값 잡음 
				System.out.println(code+"-->"+ (char)code);
				*/
				//char배열로 한번에 여러문자 입력받기
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
