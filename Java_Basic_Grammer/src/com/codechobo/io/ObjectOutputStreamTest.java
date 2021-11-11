package com.codechobo.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
/*
 직렬화 : 말그대로 객체를 직렬화하여 전송 가능한 형태로 만드는 것을 의미한다.
  객체들의 데이터를 연속적인 데이터로 변형하여 Stream을 통해 데이터를 읽도록 해준다.
이것은 주로 객체들을 통째로 파일로 저장하거나 전송하고 싶을 때 주로 사용된다.

FileOutputStream : byte단위로 파일을 기록하는 클래스 입니다.
자바 JVM의 입장에서 바이트 배열을 파일로 내보내는 역할을 하는 클래스입니다
파일이 존재하면 삭제 후 생성되기 때문에 기존의 파일이 지워집니다.

새로운 파일을 만들더라도 true를 사용하는 밑의 예제를 사용하는 경우도 있다.

InputStream과 같이 사용 후에는 반드시 close( ) 해줘야 파일에 접근할 수가 있습니다.
 이터는 SQL 없이 파일로 사용이 가능하다.
접근하기도 좋고 DB보다는 파일이 편리할 때가 많이 있습니다.

 */

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
	}
	public void start() {
		//객체를 파일로 쓰기
		try {
			File f = new File("C://javaFile/ObjectData.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//파일에 쓰기할 객체
			DataVO vo = new DataVO();
			
			vo.setNum(99999);
			vo.setName("손흥민");
			vo.setTel("010-9898-7878");
			vo.setAddr("서울시 강남구");
			vo.setNow(Calendar.getInstance()); // 객체가 만들어지는 시점에 시간 
			oos.writeObject(vo);
			oos.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest().start();
		System.out.println("객체를 파일로 저장하고 프로그램이 종료되었습니다.");
	}

}
