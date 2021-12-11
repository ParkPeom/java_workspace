package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressApp {
	
	public static void main(String[] args) throws UnknownHostException {
		
		// ���� ȣ��Ʈ = ���� ������� ��ǻ�� ȣ��Ʈ  
		InetAddress myComputer = InetAddress.getLocalHost();
		System.out.println("My Computer = " + myComputer);
		
		// ����� ��ǻ�� �̸��� ��ȯ�ϴ� �޼ҵ� 
		System.out.println("��ǻ�� �̸�(Host Name) = " + myComputer.getHostName());
		
		// ����� ��Ʈ��ũ �ּҸ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("��Ʈ��ũ �ּ�(IP Address) = " + myComputer.getHostAddress());
		System.out.println("========================================================");
		
		// ���޹��� ��ǻ�� �̸��� ���� ��Ʈ��ũ �ּҿ�
		InetAddress itwill = InetAddress.getByName("www.itwill.xyz");
		System.out.println("[www.itwill.xyz]�� IP Address = " + itwill.getHostAddress());
		System.out.println("==========================================================");
		
		// InetAddress.getAllByName(String host) : ���޹��� ��ǻ�� �̸��� ���� ��� ��Ʈ��ũ
		// �ּҿ� ��ǻ�� �̸��� ����� InetAddress �ν��Ͻ��� �����Ͽ� �迭�� ��ȯ�ϴ� �޼ҵ�
		
		InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
		for(InetAddress address : naver) {
			System.out.println("[www.naver.com]�� IP Address = "+address.getHostAddress());
			System.out.println("=========================================================");
		}
	}
}
