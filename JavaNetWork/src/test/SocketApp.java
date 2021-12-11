package test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketApp {
	public static void main(String[] args) {
		
	try {	
		// 서버 컴퓨터 이름 또는 포트 번호를 전달받아 서버에 접속된 socket 인스턴스 생성
		Socket socket = new Socket("www.naver.com",80);
		
		// 소켓 정보를 문자열로 반환 
		System.out.println("socket = " + socket.toString());
		
		// 서버 컴퓨터 이름과 네트워크 주소가 저장된 InetAddress 인스턴스 반환 
		System.out.println("Remote IP Address = " + socket.getInetAddress().getHostName());
	
		// 서버의 포트번호 
		System.out.println("Remote Port Number = " + socket.getPort());
		
		// 클라이언트의 컴퓨터 이름 과 네트워크 주소가 저장된 InetAddress 인스턴스 반환 
		System.out.println(socket.getLocalAddress().getHostAddress());

		// 로컬 컴퓨터 (현재 사용중) 포트 번호를 반환 하는 메소드 
		System.out.println(socket.getLocalPort());
		
		// Socket.close() : 소켓을 제거하는 메소드 - 접속 종료 
		socket.close();
		
		}catch(UnknownHostException e) {
			System.out.println("[에러] 서버 컴퓨터를 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("[에러] 서버 컴퓨터를 찾을수 없습니다.");
		}
	}
}
