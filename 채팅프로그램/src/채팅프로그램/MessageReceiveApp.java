package 채팅프로그램;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//연결 컴퓨터에서 보내온 메세지를 전달받아 출력하는 UDP 기반의 네트워크 프로그램
public class MessageReceiveApp {
	
	public static void main(String[] args) throws IOException {
		// DatagramSocket(int port) 생성자로 데이타를 전달받기 위한 DatagramSocket 인스턴스 생성
		// 받는건 포트로 활성화 시켜줌 
		// => SocketException 발생 : 포트번호 충돌 - 예외 처리 
		DatagramSocket socket = new DatagramSocket(10000);
		
		//전달받은 데이타를 저장하기 위한 byte 배열 생성
		byte[] data = new byte[1024];
		// DatagramPacket(byte[] buf , int length) : 연결 컴퓨터에서 보내온 패킷을 저장하기
		// 위한 DatagramPacket 인스턴스를 생성하는 생성자 
		//연결 컴퓨터에서 보내온 패킷을 저장하기 위한 DatagramPacket 인스턴스를 생성한다.
		DatagramPacket packet = new DatagramPacket(data , data.length); // 
		
		System.out.print("메세지 수신 중...");
		// socket.receive : 연결 컴퓨터에서 보내온 데이터를 받아
		// 패킷에 저장하는 메소드 - 패킷이 저장되기 전까지 스레드 일시 중지
		socket.receive(packet);
		
		// DatagramPacket : 인스턴스에 저장된 전달값(byte 배열)을 이용하여 String인스턴스로 변환하여 저장   
		String message = new String(data);
		
		System.out.println("받은 메세지 " + message );
		
		socket.close();
	}
}
