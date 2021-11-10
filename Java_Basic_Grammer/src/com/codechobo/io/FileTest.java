package com.codechobo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {

	}
	public void start() {
		//File객체는 파일에 입력 또는 출력을 할수 있으며,
		//	폴더, 파일을 생성 삭제할 수 있다.
		//	파일객체 생성시 드라이브명, 경로, 파일명은 절대경로여야 한다.
		//  상대경로 : 내 현재 위치가 기준
		//  절대경로 : 파일의 어디어디어디 위치에 있다
		File f1 = new File("C://javaFile"); // 드라이브명 
		File f2 = new File("C://javaFile/test.txt"); // 경로명
		File f3 = new File(f1,"ggm.txt");
		File f4 = new File("C://javaFile","sample.txt"); // 드라이브명 , 경로명 
		//폴더인지 확인하여 폴더이면 true, 아니면 false를 리턴한다.
		boolean isDir = f1.isDirectory();
		System.out.println("isDir->"+ isDir);
		File f5 = new File("C://aaa/bbb");
		
		//폴더생성
		if(!f5.exists()) {// 현재컴퓨터에 폴더가 있으면 true, 없으면 false를 구해준다.
			// mkdir() -> 상위폴더가 존재할때 생성된다.
			// mkdirs() -> 상위폴더가 없으면 상위폴더도 생성해준다.
			//폴더생성
			if(f5.mkdirs()) {
				System.out.println("폴더가 생성되었습니다.");
			} else {
				System.out.println("폴더생성 실패하였습니다."); // 중복될경우 
			}
		}
		//파일생성
		if(!f2.exists()) {
			try {
				if(f2.createNewFile() ) {
					System.out.println("파일이 생성되었습니다.");
				} else {
					System.out.println("파일생성 실패하였습니다.");
				}
			} catch(IOException e) {
				System.out.println("파일생성에러....");
			}
		}
		//마지막 수정일 알아내기
		File f6 = new File(f1,"Diamond2.java"); // 경로 , 파일명 
		long lastDate = f6.lastModified();
		System.out.println(lastDate);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(lastDate);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		String lastDateTxt = fmt.format(cal.getTime());
		System.out.println("마지막 수정일 --> " + lastDateTxt);
		
		System.out.println("exe ->" + f6.canExecute());
		System.out.println("canRead ->" + f6.canRead());
		System.out.println("canRWrite -> " + f6.canWrite());
		//
		System.out.println("드라이브,경로,파일->" + f6.getPath());
		System.out.println("드라이브,경로,파일->" + f6.getAbsolutePath());
		System.out.println("파일->" + f6.getName());
		System.out.println("드라이브 경로->" + f6.getParent());
		
		//폴더와 파일목록 구해오기
		File f7 = new File("c://");
		File[] list = f7.listFiles();
		
		for(File f : list) {
			if(f.isDirectory()) {
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[숨김폴더]");
				}
				System.out.println(f.getPath()+"[폴더]");
			} else if(f.isFile()) {
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[숨김파일]");
				} else  {
					System.out.println(f.getPath()+"[파일]");					
				}
			}
		}
		// 현재시스템의 드라이브 목록 구하기
		File root[] = File.listRoots();
		for(File f : root) {
			System.out.println(f.getPath());
		}
		//파일의 byte수 구하기
		long filesize = f6.length();
		System.out.println("파일 크기 " + filesize);
		
		//파일삭제하기
		f2.delete();
	}
	public static void main(String[] args) {
		new FileTest().start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
}
