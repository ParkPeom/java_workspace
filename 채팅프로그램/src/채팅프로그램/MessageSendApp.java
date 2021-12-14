package 채팅프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 키보드로 메세지를 입력받아 다른 컴퓨터에게 전달하는 UDP 프로그램
// => DatagramSocket 클래스와 DatagramPacket 클래스로 UDP 프로그램 작성 
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message = br.readLine();
		
		// DatagramSocket : 다른 컴퓨터와 연결되기 위한 기능을 제공하는 클래스
		// => DatagramSocket 클래스의 기본 생성자로 정보를 전달하기 위한 소켓 생성
		DatagramSocket socket = new DatagramSocket();
		
		//연결하고자 하는 컴퓨터의 네트워크 정보가 저장된 InetAddress 인스턴스를 반환받아 저장 
		InetAddress address = InetAddress.getByName("10.10.4.102");
		
		//String.getBytes() : String 인스턴스에 저장된 문자열을 byte 배열로 변환하여 반환하는 메소드
		// => 값을 1Byte의 원시 데이타(변형되지 않은 순수한 값)로 표현 
		byte[] data = message.getBytes(); // 입력한 메세지를 순수한 바이트배열로 보냄
		// DatagramPacket : 패킷정보를 저장하기 위한 클래스
		// => 패킷(Packet) : 네트워크 에서 정보를 전달하기 위한 단위 
		// => DatagramPacket(byte[] buf , int length , InetAddress address , int port)
		// => 다른 컴퓨터로 보낼 정보를 저장한 DatagramPacket 인스턴스를 생성하는 생성자 
		// => buf : 전달값 , length : 패킷크기 , address : 전달컴퓨터의 네트워크 정보 , port : 전달 컴퓨터의 활성화 포트 번호  
		DatagramPacket packet = new DatagramPacket(data, data.length , address , 10000);
		
		// DatagramPacket.send(DatagramPacket packet) : 연결 컴퓨터에게 패킷을 전달하는 메소드
		socket.send(packet);
		// DatagramSocket.close() : 소켓을 제거하는 메소드 - 접속 종료 
		socket.close();
		System.out.println("[결과] 연결 컴퓨터에게 메세지를 보냈습니다.");
	}
}
