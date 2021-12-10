import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//서버에 접속하여 서버에서 보내온 날짜와 시간을 받아 출력하는 클라이언트 프로그램
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket 인스턴스 생성 - 서버 접속
			Socket socket=new Socket("172.31.98.131", 3000);
			
			//Socket.getInputStream() : Socket 인스턴스의 입력스트림(InputStream 인스턴스)을 반환하는 메소드
			// => 접속된 컴퓨터에서 보내온 원시 데이타(1Byte)를 전달받는 입력스트림
			InputStream in=socket.getInputStream();
			
			//Socket 인스턴스의 입력스트림을 전달받아 객체를 전달받을 수 있는 입력스트림으로 확장하여 저장
			ObjectInputStream stream=new ObjectInputStream(in);
			
			//ObjectInputStream.readObject() : 입력스트림을 이용하여 객체(인스턴스)를 전달받는 메소드
			// => Object 타입으로 인스턴스가 반환되므로 명시적 객체 형변환하여 참조변수에 저장
			Date date=(Date)stream.readObject();
			
			//Date 인스턴스에 저장된 날짜와 시간을 원하는 패턴의 문자열로 반환받아 출력
			System.out.println("[결과]서버에서 보내온 날짜와 시간 = "
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			
			//접속 종료
			socket.close();
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}
}