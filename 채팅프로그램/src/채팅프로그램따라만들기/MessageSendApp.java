package 채팅프로그램따라만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("전달 메세지 입력 >> ");
		String message = br.readLine();
		
		DatagramSocket socket = new DatagramSocket();
		
		InetAddress address = InetAddress.getByName("10.10.4.102");
		
		byte[] data = message.getBytes();
		
		DatagramPacket packet = new DatagramPacket(data, data.length , address , 10000);
		
		socket.send(packet);
		socket.close();
		
		System.out.println("[결과] 연결 컴퓨터에게 메세지를 보냈습니다.");
	}
}
