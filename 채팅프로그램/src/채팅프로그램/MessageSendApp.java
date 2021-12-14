package ä�����α׷�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Ű����� �޼����� �Է¹޾� �ٸ� ��ǻ�Ϳ��� �����ϴ� UDP ���α׷�
// => DatagramSocket Ŭ������ DatagramPacket Ŭ������ UDP ���α׷� �ۼ� 
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���� �޼��� �Է� >> ");
		String message = br.readLine();
		
		// DatagramSocket : �ٸ� ��ǻ�Ϳ� ����Ǳ� ���� ����� �����ϴ� Ŭ����
		// => DatagramSocket Ŭ������ �⺻ �����ڷ� ������ �����ϱ� ���� ���� ����
		DatagramSocket socket = new DatagramSocket();
		
		//�����ϰ��� �ϴ� ��ǻ���� ��Ʈ��ũ ������ ����� InetAddress �ν��Ͻ��� ��ȯ�޾� ���� 
		InetAddress address = InetAddress.getByName("10.10.4.102");
		
		//String.getBytes() : String �ν��Ͻ��� ����� ���ڿ��� byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => ���� 1Byte�� ���� ����Ÿ(�������� ���� ������ ��)�� ǥ�� 
		byte[] data = message.getBytes(); // �Է��� �޼����� ������ ����Ʈ�迭�� ����
		// DatagramPacket : ��Ŷ������ �����ϱ� ���� Ŭ����
		// => ��Ŷ(Packet) : ��Ʈ��ũ ���� ������ �����ϱ� ���� ���� 
		// => DatagramPacket(byte[] buf , int length , InetAddress address , int port)
		// => �ٸ� ��ǻ�ͷ� ���� ������ ������ DatagramPacket �ν��Ͻ��� �����ϴ� ������ 
		// => buf : ���ް� , length : ��Ŷũ�� , address : ������ǻ���� ��Ʈ��ũ ���� , port : ���� ��ǻ���� Ȱ��ȭ ��Ʈ ��ȣ  
		DatagramPacket packet = new DatagramPacket(data, data.length , address , 10000);
		
		// DatagramPacket.send(DatagramPacket packet) : ���� ��ǻ�Ϳ��� ��Ŷ�� �����ϴ� �޼ҵ�
		socket.send(packet);
		// DatagramSocket.close() : ������ �����ϴ� �޼ҵ� - ���� ���� 
		socket.close();
		System.out.println("[���] ���� ��ǻ�Ϳ��� �޼����� ���½��ϴ�.");
	}
}
