import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Socket : TCP 기반의 네트워크 프로그램 에서 클라이언트를 구현하기 위한 클래스
// => 서버의 컴퓨터 이름과 네트워크 주소 및 클라이언트(로컬 컴퓨터)의 네트워크 주소 저장
// => 서버에 접속하여 값을 전달하거나 전달받을 수 있는 인스턴스를 생성하기 위한 클래스
// => 서버와 클라이언트(로컬 컴퓨터)의 컴퓨터 이름과 네크워크 주소 및 포트번호 저장 
// => 접속된 컴퓨터 간의 값을 주고 받기 위한 입력 스트림과 출력스트림이 자동 생성 되어 제공

public class SocketApp {
	
	public static void main(String[] args) {
		try {
			//Socket(String host,int port) : 서버 컴퓨터의 이름 또는 네트워크 주소와 포트 
			//번호를 전달받아 서버에 접속된 socket 인스턴스를 생성하여 반환하는 메소드 
			Socket socket = new Socket("www.daum.net",80);
			
			// Skcket 인스턴스에 저장된 소켓 정보를 문자열로 변환하여 반환 
			System.out.println("socktet = " + socket);
			
			// Socket 인스턴스에 저장된 원격 컴퓨터(서버)의 컴퓨터의
			// 이름과 네트워크 주소가 저장된 InetAddress 인스턴스를 반환하는 메소드
			System.out.println("Remote IP Address = " + socket.getInetAddress().getHostAddress());
			// Socket 인스턴스에 저장된 원격 컴퓨터(서버)의 포트번호를 반환 
			System.out.println("Remote Port Number = " + socket.getPort());
		
			// 로컬 컴퓨터(클라이언트)의 컴퓨터 이름과 네트워크 주소가 저장된 InetAddress 인스턴스 반환
			System.out.println(socket.getLocalAddress().getHostAddress());
			
			// 로컬 컴퓨터의 포트번호를 반환하는 메소드
			System.out.println(socket.getLocalPort());
			
			//Socket.close() : 소켓을 제거하는 메소드 - 접속 종료 
			socket.close();
			
		} catch(UnknownHostException e) {
			System.out.println("[에러]서버 컴퓨터를 찾을 수 없습니다.");
		} catch(IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
		
	}
}
