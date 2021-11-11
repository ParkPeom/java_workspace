package com.codechobo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ObjectInputStreamTest {
	
	// 역직렬화
	public ObjectInputStreamTest() {
	}
	public void start() {
		try {
		File f = new File("c://javaFile/ObjectData.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		DataVO vo = (DataVO)obj;
		vo.print();
		
		Calendar date = vo.getNow();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dataStr = fmt.format(date.getTime());
		System.out.println(dataStr);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		new ObjectInputStreamTest().start();
	}

}
