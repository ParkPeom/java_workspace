import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressApp {
	
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : 네트워크 주소(IP Address)와 컴퓨터 이름(HostName)을 저장하기 위한 클래스
				//InetAddress.getLocalHost() : 로컬 컴퓨터의 네트워크 주소와 컴퓨터 이름이 저장된 
				//InetAddress 인스턴스를 생성하여 반환하는 메소드
				// => UnknownHostException 발생 : 네트워크에서 컴퓨터 이름의 컴퓨터를 검색할 수 없는 경우 발생되는 예외
				// => 이더넷(Ethernet) 장치에 등록된 네트워크 정보 제공
				//로컬 컴퓨터(현재 사용중인 컴퓨터)는 기본적으로 [127.0.0.1]의 네트워크 주소와 
				//[localhost]의 컴퓨터 이름으로 설정 
				InetAddress myComputer=InetAddress.getLocalHost();
				
				//InetAddress.toString() : InetAddress 인스턴스에 저장된 네트워크 주소와 컴퓨터 이름을
				//문자열로 변환하여 반환하는 메소드 - 참조변수를 출력할 경우 자동 호출되는 메소드
				System.out.println("myComputer = "+myComputer);
				
				//InetAddress.getHostName() : InetAddress 인스턴스에 저장된 컴퓨터 이름을 반환하는 메소드
				System.out.println("컴퓨터 이름(HostName) = "+myComputer.getHostName());

				//InetAddress.getHostAddress() : InetAddress 인스턴스에 저장된 네트워크 주소를 반환하는 메소드
				System.out.println("네트워크 주소(IP Address) = "+myComputer.getHostAddress());
				System.out.println("==============================================================");
				//InetAddress.getByName(String host) : 전달받은 컴퓨터 이름에 대한 네트워크 주소와 
				//컴퓨터 이름이 저장된 InetAddress 인스턴스를 생성하여 반환하는 메소드
				InetAddress itwill=InetAddress.getByName("www.itwill.xyz");
				
				System.out.println("[www.itwill.xyz]의 IP Address = "+itwill.getHostAddress());
				System.out.println("==============================================================");
				//InetAddress.getAllByName(String host) : 전달받은 컴퓨터 이름에 대한 모든 네트워크  
				//주소와 컴퓨터 이름이 저장된 InetAddress 인스턴스를 생성하여 배열로 반환하는 메소드
				InetAddress[] naver=InetAddress.getAllByName("www.naver.com");
				
				for(InetAddress address:naver) {
				System.out.println("[www.naver.com]의 IP Address = "+address.getHostAddress());
			}
			System.out.println("==============================================================");
		}
	}

