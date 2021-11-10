package com.codechobo.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
	}
	public void start() {
		//Input(1byte), Reader(1char) -- 외부에서 자바로 데이터를 가지고 들어온다.
		
		//InputStream은 객체를 직접생성할수 없으며, System클래스의 멤버변수에 
		//있는 final 객체를 이용하여야 한다. 
		InputStream is = System.in; // new InputStream();
		
		try {
			System.out.print("입력=");
		
			while(true) {		
				/*
				int inData = is.read();//콘솔에서 1byte의 문자를 입력한다.
				if(inData==-1) break;  // read()한 byte가 없으면 -1이 리턴된다.
				//System.out.println(inData+"->"+(char)inData);
				System.out.print((char)inData); // 엔터 2바이트인 13 , 10이 나온다.
				*/
				/*배열을 이용한 입력*/
				byte[] inData = new byte[20];
				int cnt = is.read(inData);//한번에 byte배열의 크기만큼 입력받고 입력받은 문자수를 리턴해준다.  
				if(cnt<=0) break;
				System.out.println(cnt+"-->" + new String(inData));
				
				/*배열의 특정위치에 입력받은 데이터 대입하기
				byte[] inData = new byte[10];
				int cnt = is.read(inData, 4, 4);// index 4의 위치에 4byte정보를 입력하라.
				if(cnt<=0) break;
				System.out.println("입력받은 바이트 문자수="+cnt);
				for(int i=0; i<inData.length; i++) {
					System.out.println("inData["+i+"]="+inData[i]+"-->"+(char)inData[i]);
				}*/
				
			}
		}catch(IOException i) {
			i.printStackTrace();
		}		
	}
	public static void main(String[] args) {
		new InputStreamTest().start();
	}
}
