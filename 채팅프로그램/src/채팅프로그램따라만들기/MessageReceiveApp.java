package 채팅프로그램따라만들기;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MessageReceiveApp {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket socket = new DatagramSocket(10000);
		
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data , data.length);
		System.out.print("메세지 수진 중...");
		socket.receive(packet);
		
		String message = new String(data);
		System.out.println("받은 메세지 " + message);
		socket.close();
	}
}
