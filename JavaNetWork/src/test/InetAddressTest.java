package test;

import java.net.InetAddress;

public class InetAddressTest {
	
	public InetAddressTest() {

	try {	
		// �� ���� ������ 172.30.1.12
		// ���� �ý��� �ּ� �� �̸� �˾Ƴ��� 
		InetAddress ial = InetAddress.getLocalHost(); 
		String hostAddress = ial.getHostAddress();
		String hostName = ial.getHostName();
		System.out.println(hostAddress + " > " + hostName);
		
		// (DNS)�������� �̿��Ͽ� [�ּ�] �� [�̸�] �˾Ƴ��� 
		InetAddress ia2 = InetAddress.getByName("www.naver.com");
		System.out.println("ia2.address->" + ia2.getHostAddress());
		System.out.println("ia2.name->" + ia2.getHostName());
		
		// �ּ��� ip ������ŭ �迭�� ����
		InetAddress[] ia3 = InetAddress.getAllByName("www.naver.com");
		for(InetAddress address : ia3) {
			System.out.println(address.getHostAddress() + " , " + address.getHostName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new InetAddressTest();
	}
}
