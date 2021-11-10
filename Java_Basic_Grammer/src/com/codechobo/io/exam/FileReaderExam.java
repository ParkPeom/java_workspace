package com.codechobo.io.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExam {

	public void start() {
		File f = new File("C:\\javaio\\exam1","exam1.txt");
		try {
		FileReader fr = new FileReader(f);
		System.out.println("=====FileReader=====");
		while(true) {
			int inData = fr.read();
			if(inData == -1) break;
				System.out.print((char)inData);
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을수없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println();	
		System.out.println("=====FileInputStream=====");
		try {
		FileInputStream fis = new FileInputStream(f);
		while(true) {
			int inData2 = fis.read();
			if(inData2 == -1) break;
				System.out.print((char)inData2);
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을수없습니다.");
		}catch( IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();	
		System.out.println("=====BufferedReader=====");
		File f2 = new File("C:\\javaio\\exam3","exam3.txt");
		try { 
		FileReader fr2 = new FileReader(f2);
		BufferedReader br = new BufferedReader(fr2);
		
		String txt = br.readLine();
		System.out.print(txt);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileReaderExam().start();
	
	}
}
