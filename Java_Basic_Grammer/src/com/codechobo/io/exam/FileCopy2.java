package com.codechobo.io.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
	public FileCopy2() {}
	public void start() {
		try {
			File origin = new File("C://javaFile","duke.PNG");
			//1. 원본 파일명 알아냄
			String fileName = origin.getName();
			//2. 새로운 파일에 
			File target = new File("C://etc",fileName);
			
			//3.새로운파일이 이미 존재하면 
			if(target.exists()) {
				//4. .위치로 파일명 , 확장자 구함 
				int point = fileName.lastIndexOf(".");
				//5. 파일명
				String file = fileName.substring(0,point);
				//6. 확장자명
				String ext = fileName.substring(point + 1);
				
				int cnt = 1;
				
				while(true) {
					// 7. 새로운파일명에 (숫자) 카운트됨 
					String newName = file +"("+ cnt++ +")."+ext;
					target = new File("C://etc",newName);
					// 8. 존재하지않으면 빠져나감 
					if(!target.exists()) {
						break;
					}
					
				}
			}
			// 9. 새로운파일이면 복사하기
			FileInputStream fis = new FileInputStream(origin);
			FileOutputStream fos = new FileOutputStream(target);
			
			while(true) {
				int num = fis.read();
				if(num == -1) break;
				fos.write(num);
			}
		}catch(IOException e) {
			System.out.println("파일이존재하지않습니다.");
		}
		
	}
	public static void main(String[] args) {
		new FileCopy2().start();
	}
}
