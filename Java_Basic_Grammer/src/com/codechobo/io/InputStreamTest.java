package com.codechobo.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
	}
	public void start() {
		//Input(1byte), Reader(1char) -- �ܺο��� �ڹٷ� �����͸� ������ ���´�.
		
		//InputStream�� ��ü�� ���������Ҽ� ������, SystemŬ������ ��������� 
		//�ִ� final ��ü�� �̿��Ͽ��� �Ѵ�. 
		InputStream is = System.in; // new InputStream();
		
		try {
			System.out.print("�Է�=");
		
			while(true) {		
				/*
				int inData = is.read();//�ֿܼ��� 1byte�� ���ڸ� �Է��Ѵ�.
				if(inData==-1) break;  // read()�� byte�� ������ -1�� ���ϵȴ�.
				//System.out.println(inData+"->"+(char)inData);
				System.out.print((char)inData); // ���� 2����Ʈ�� 13 , 10�� ���´�.
				*/
				/*�迭�� �̿��� �Է�*/
				byte[] inData = new byte[20];
				int cnt = is.read(inData);//�ѹ��� byte�迭�� ũ�⸸ŭ �Է¹ް� �Է¹��� ���ڼ��� �������ش�.  
				if(cnt<=0) break;
				System.out.println(cnt+"-->" + new String(inData));
				
				/*�迭�� Ư����ġ�� �Է¹��� ������ �����ϱ�
				byte[] inData = new byte[10];
				int cnt = is.read(inData, 4, 4);// index 4�� ��ġ�� 4byte������ �Է��϶�.
				if(cnt<=0) break;
				System.out.println("�Է¹��� ����Ʈ ���ڼ�="+cnt);
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
