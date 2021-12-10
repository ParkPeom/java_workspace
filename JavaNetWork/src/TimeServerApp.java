import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속 클라이언트에게 서버 컴퓨터의 날짜와 시간을 전달하는 서버 프로그램
// => NTP(Network Time Protocol) Sever : 날짜와 시간을 제공하는 컴퓨터  
public class TimeServerApp {
	
	public static void main(String[] args) {
		ServerSocket ntpServer =  null;
		
		try {
			//ServerSocket 인스턴스 생성 -  서버 동작
			ntpServer = new ServerSocket(3000);
			System.out.println("[메세지] NTP Server Running...");
			// 서버는 다수의 클라이언트 접속을 허용하기 위해 무한 루프를 이용하여 처리
			// 횟수를 모르는 것은 무한루프 
			while(true) {
				// accept() : 클라이언트 접속을 기다리는 메소드 
				// => 클라이언트 접속 전까지 스레드 일시 중지
				// => 클라이언트가 접속되면 클라이언트 소켓과 연결될 Socket 인스턴스를 생성하여 반환 
				// => 현재 접속 중인 클라이언트 수 만큼 서버에는 Socket 인스턴스 생성
				Socket socket = ntpServer.accept();
				
				/*
				// socket.getOutputStream() : Socket 인스턴스의 출력스트림(OutputStream 인스턴스)을 반환하는 메소드
				// => 접속된 컴퓨터에게 원시 데이터(1Byte)를 전달하는 출력 스트림 
				OutputStream out = socket.getOutputStream();
				
				// Socket 인스턴스의 출력 스트림을 전달받아 객체를 전달 할 수 있는 출력 스트림으로 확장하여 저장 
				ObjectOutputStream stream = new ObjectOutputStream(out);
				
				// 클라이 언트에게 전달될 서버의 현재 날짜와  날짜 시간이 저장된 Date 인스턴스 생성
				Date date = new Date();
				
				// writeObject(Object obj) : 출력스트림을 이용하여
				// 객체(인스턴스)를 전달하는 메소드
				//=> 클라이언트에게 서버의 현재 날짜와 시간을 전달 
				stream.writeObject(date); // 클라이언트에게 date를 주겠다.
				*/			
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				//로그(Log) 출력 : 서버의 기록 (서버에 접속된 사용자 기록)
				System.out.println("[로그]클라이언트[" + socket.getInetAddress().getHostAddress() +"]에게 날짜와 시간을 제공 하였습니다.");
				// getLocalAddress : 서버의 주소
				// getInetAddress : 클라이언트의 주소 
				
				// 소켓 제거 - 클라이언트와의 접속 종료 
				socket.close();
			}
		}catch(IOException e) {
			System.out.println("[에러] 서버에 네트워크 문제가 발생하였습니다. ");
		}
	}
}
