package com.codechobo.itwill.collection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {
		
	}
	public void start() {
		VectorTest vt = new VectorTest();
		Vector v = vt.getData();
		//°´Ã¼ÀÇ °¹¼ö: size()
		System.out.println("size()=->"+ v.size());
		
		//
		String name = (String)v.firstElement();
		System.out.println("name->"+ name);
		Integer vInt = (Integer)v.get(1);
		System.out.println("vInt->"+ vInt);
		Calendar date = (Calendar)v.get(2);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("date->"+ fmt.format(date.getTime()));
		Random ran = (Random)v.get(3);
		System.out.println("ran->"+ ran.nextInt(100));
		
		MemberVO vo1 = (MemberVO)v.get(4);
		vo1.memberOutput();
		
		MemberVO vo2 = (MemberVO)v.get(5);
		vo2.memberOutput();
	}
	public static void main(String[] args) {
		new VectorMain().start();
	}
}
