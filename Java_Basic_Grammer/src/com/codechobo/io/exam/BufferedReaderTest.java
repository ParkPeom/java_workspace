package com.codechobo.io.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
	
	}
	public static void main(String[] args) {
		try { 
		InputStream input = System.in;	
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		love l = (a , b) -> System.out.println(a + b);
		l.sum(3, 5);
		
		String line = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}


@FunctionalInterface
interface love {
	void sum(int a, int b);
}
