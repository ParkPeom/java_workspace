package ä�����α׷�;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//���� ��ǻ�Ϳ��� ������ �޼����� ���޹޾� ����ϴ� UDP ����� ��Ʈ��ũ ���α׷�
public class MessageReceiveApp {
	
	public static void main(String[] args) throws IOException {
		// DatagramSocket(int port) �����ڷ� ����Ÿ�� ���޹ޱ� ���� DatagramSocket �ν��Ͻ� ����
		// �޴°� ��Ʈ�� Ȱ��ȭ ������ 
		// => SocketException �߻� : ��Ʈ��ȣ �浹 - ���� ó�� 
		DatagramSocket socket = new DatagramSocket(10000);
		
		//���޹��� ����Ÿ�� �����ϱ� ���� byte �迭 ����
		byte[] data = new byte[1024];
		// DatagramPacket(byte[] buf , int length) : ���� ��ǻ�Ϳ��� ������ ��Ŷ�� �����ϱ�
		// ���� DatagramPacket �ν��Ͻ��� �����ϴ� ������ 
		//���� ��ǻ�Ϳ��� ������ ��Ŷ�� �����ϱ� ���� DatagramPacket �ν��Ͻ��� �����Ѵ�.
		DatagramPacket packet = new DatagramPacket(data , data.length); // 
		
		System.out.print("�޼��� ���� ��...");
		// socket.receive : ���� ��ǻ�Ϳ��� ������ �����͸� �޾�
		// ��Ŷ�� �����ϴ� �޼ҵ� - ��Ŷ�� ����Ǳ� ������ ������ �Ͻ� ����
		socket.receive(packet);
		
		// DatagramPacket : �ν��Ͻ��� ����� ���ް�(byte �迭)�� �̿��Ͽ� String�ν��Ͻ��� ��ȯ�Ͽ� ����   
		String message = new String(data);
		
		System.out.println("���� �޼��� " + message );
		
		socket.close();
	}
}
