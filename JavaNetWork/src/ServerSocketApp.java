import java.io.IOException;
import java.net.ServerSocket;

// 서버(Server) : 다른 컴퓨터가 접속할 수 있는 환경을 제공하는 컴퓨터
// 클라이언트(Client) : 서버에 접속할 수 있는 컴퓨터

// ServerSocket : [TCP 기반] 의 네트워크 프로그램에서 서버를 구현하기 위한 클래스
//=>  클라이언트 접속하기 위한 특정 포트(Port)를 활성화 하여 인스턴스 생성 
//=>  클라이언트가 서버에 접속된 후 서버와 클라이언트 간에 데이터 전달이 가능

// ServerSocket 클래스로 서버에서 사용 가능한 포트 번호를 검색하는 프로그램
// C:\Users\fight> netstat -na  CMD 에서 포트 검색 

public class ServerSocketApp {

	public static void main(String[] args) {
		for(int i = 2000; i <= 9000; i+=1000) {
			try {
				//ServerSocket(int port) : 포트 번호를 전달받아 ServerSocket 인스턴스를 생성하는 생성자
				//=> 전달된 포트 번호를 다른 네트워크 프로그램에서 사용중인 경우 IOException  
				ServerSocket serverSocket = new ServerSocket(i);
				System.out.println("[메세지]" + i +"번 포트는 사용 가능 ");
				// serverSocket.close(0 : 서버 기능을 제거 하는 메소드)
				serverSocket.close();
			} catch(IOException e) {
				System.out.println("[에러]"+i+"번 포트는 이미 사용 중 입니다.");
			}
		}
	}
}
