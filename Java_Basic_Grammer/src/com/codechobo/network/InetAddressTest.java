package com.codechobo.network;

import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		try {
		// IPv4 �ּ� 192.168.56.1 
		// ����ý����� ip�� ���Ѵ�.
			InetAddress ial= InetAddress.getLocalHost(); // static
			String hostAddress = ial.getHostAddress();
			String hostName = ial.getHostName();
			System.out.println(hostAddress+"->"+hostName);
			
			//�������� �̿��Ͽ� ip������
			InetAddress ia2 = InetAddress.getByName("www.nate.com");
			System.out.println("ia2.address->"+ ia2.getHostAddress());
			System.out.println("ia2.name->"+ ia2.getHostName());
			
			// ip ���ּ�  �����ּҾ��ʿ䰡����..
			InetAddress ia3 = InetAddress.getByName("120.50.131.112");
			System.out.println("ia2.address->"+ ia3.getHostAddress());
			System.out.println("ia2.name->"+ ia3.getHostName());
			
			// ������ŭ �迭�� ���� 
			InetAddress[] ia4 = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ia : ia4 ) {
				System.out.println(ia.getHostAddress()+","+ia.getHostName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new InetAddressTest();
	}
}
