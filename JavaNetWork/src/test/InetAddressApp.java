package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressApp {
	
	public static void main(String[] args) throws UnknownHostException {
		
		// 로컬 호스트 = 현재 사용중인 컴퓨터 호스트  
		InetAddress myComputer = InetAddress.getLocalHost();
		System.out.println("My Computer = " + myComputer);
		
		// 저장된 컴퓨터 이름을 반환하는 메소드 
		System.out.println("컴퓨터 이름(Host Name) = " + myComputer.getHostName());
		
		// 저장된 네트워크 주소를 반환하는 메소드
		System.out.println("네트워크 주소(IP Address) = " + myComputer.getHostAddress());
		System.out.println("========================================================");
		
		// 전달받은 컴퓨터 이름에 대한 네트워크 주소와
		InetAddress itwill = InetAddress.getByName("www.itwill.xyz");
		System.out.println("[www.itwill.xyz]의 IP Address = " + itwill.getHostAddress());
		System.out.println("==========================================================");
		
		// InetAddress.getAllByName(String host) : 전달받은 컴퓨터 이름에 대한 모든 네트워크
		// 주소와 컴퓨터 이름이 저장된 InetAddress 인스턴스를 생성하여 배열로 반환하는 메소드
		
		InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
		for(InetAddress address : naver) {
			System.out.println("[www.naver.com]의 IP Address = "+address.getHostAddress());
			System.out.println("=========================================================");
		}
	}
}
