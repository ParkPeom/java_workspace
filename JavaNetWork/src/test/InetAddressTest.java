package test;

import java.net.InetAddress;

public class InetAddressTest {
	
	public InetAddressTest() {

	try {	
		// 내 로컬 아이피 172.30.1.12
		// 현재 시스템 주소 와 이름 알아내기 
		InetAddress ial = InetAddress.getLocalHost(); 
		String hostAddress = ial.getHostAddress();
		String hostName = ial.getHostName();
		System.out.println(hostAddress + " > " + hostName);
		
		// (DNS)도메인을 이용하여 [주소] 와 [이름] 알아내기 
		InetAddress ia2 = InetAddress.getByName("www.naver.com");
		System.out.println("ia2.address->" + ia2.getHostAddress());
		System.out.println("ia2.name->" + ia2.getHostName());
		
		// 주소의 ip 개수만큼 배열로 리턴
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
