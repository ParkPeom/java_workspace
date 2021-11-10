package com.codechobo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {

	}
	public void start() {
		//버퍼에 문자단위 입력받은 데이터를 저장후 한줄씩 입력할 수 있는 클래스이다.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			while(true) {
				System.out.print("입력=");
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
