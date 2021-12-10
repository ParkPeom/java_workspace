import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//서버에 접속된 클라이언트가 보내온 메세지를 전달받아 출력하는 서버 프로그램 

public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer = null;
		
	try {
		echoServer = new ServerSocket(9000);
		System.out.println("[메세지] Echo Server Running...");
		
		while(true) { 
			Socket socket = echoServer.accept();
			// 소켓의 입력스트림을 제공받아 문자열을 입력받을 수 있도록 스트림 확장
			// 클라이언트가 보내온 문자를 문자열로 
			// 1바이트 -> 2바이트 -> 여러 글자 (확장)
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 클라이언트가 보내온 메세지를 읽어 화면에 출력
			// => 클라이언트가 메세지를 보내기 전까지 스레드가 일시 중지 
			System.out.println("["+socket.getInetAddress().getHostAddress()
					+ " ] 님이 보내온 메세지 = " + in.readLine());
			socket.close();
		}
	} catch(IOException e) {
		System.out.println("[에러] 서버에 네트워크 문제가 발생하였습니다.");
		}
	}
}
