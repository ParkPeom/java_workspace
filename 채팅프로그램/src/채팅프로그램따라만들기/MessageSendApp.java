package ä�����α׷����󸸵��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���� �޼��� �Է� >> ");
		String message = br.readLine();
		
		DatagramSocket socket = new DatagramSocket();
		
		InetAddress address = InetAddress.getByName("10.10.4.102");
		
		byte[] data = message.getBytes();
		
		DatagramPacket packet = new DatagramPacket(data, data.length , address , 10000);
		
		socket.send(packet);
		socket.close();
		
		System.out.println("[���] ���� ��ǻ�Ϳ��� �޼����� ���½��ϴ�.");
	}
}
