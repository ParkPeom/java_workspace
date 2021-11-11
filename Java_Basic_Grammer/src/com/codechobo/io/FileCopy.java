package com.codechobo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public FileCopy() {
	}
	public void start() {
		try {
			//c://javaFile/natural.jfif -> c://etc/natural.jfif 복사
			//파일명이 있으면 파일명을 rename 한다. c://etc/natrual(1).jfif		
			//원본파일
			File orgFile = new File("c://javaFile/duke.PNG");
			if(orgFile.exists()) { // 복사할 파일이 있으면 복사하고 
				//새로운 파일객체
				String filename = orgFile.getName();
				File tarFile = new File("c://etc",filename); 
				
				//복사할 곳에 tarFile이 존재하는지 확인후 없으면 복사하고
				//있으면 파일 바꾼다.
				
				// 존재하면 
				if(tarFile.exists()) {
					//파일명을 변경
					int point = filename.lastIndexOf("."); //문자열에서 마지막 .의 위치 index
					String fName = filename.substring(0,point);
					//파일명(확장자제외)
					String ext = filename.substring(point + 1);
					
					int cnt = 1;
					
					while(true) {
						String newName = fName+"("+cnt++ +")."+ext; // duke(1).PNG
						tarFile = new File("c://etc",newName);
						if(!tarFile.exists()) {
							break;
						}
					}
				}
					// 존재하지않으면 복사하기 
					FileInputStream fis = new FileInputStream(orgFile); //읽고
					FileOutputStream fos = new FileOutputStream(tarFile); //쓰기
//					while(true) {
//						int data = fis.read(); // 데이터를 읽음 
//						if(data == -1) break; 
//						// 데이터가 있으면 쓴다.
//						fos.write(data);
//					}
					// 반복문을 안쓰고 구해보기
					// 바이트단위로 읽고 쓰기 
					byte[] inData = new byte[(int)orgFile.length()];
					fis.read(inData, 0, inData.length); // 읽어오고
					fos.write(inData, 0 , inData.length); // 쓰기 
					
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
			System.out.println("파일복사처리가 완료되었습니다.");
		}catch(Exception e) {
			System.out.println("예외 발생.... -> " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		new FileCopy().start();
	}
}
