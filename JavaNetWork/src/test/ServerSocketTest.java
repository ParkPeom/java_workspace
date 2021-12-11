package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	
	public ServerSocketTest() {
		
		try {
			// 1. 서버 생성
			ServerSocket servertest = new ServerSocket(1000);
			// 2. 서버에서 사용자들의 접속을 대기 
			Socket s = servertest.accept();
			
			// 5. 호스트 ip 얻어오기
			InetAddress inet = s.getInetAddress(); // 6. 접속된 호스트 IP 가져옴 
			System.out.println(inet.getHostAddress() + "---> 클라이언트 접속 했습니다.");
			
			// 7. 서버에서 호스트에게 메세지
			// byte[] 배열 생성하고 이것을 매개값 -> OutputStream write() 메서드 호출
			// 2바이트 씩 한글로 보냄 OutputStreamWriter
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			// getOutputStream 1바이트 배열 - 내보냄 OutputStreamWriter 2바이트씩(한글 출력위해)
			
			// 여기서 BufferedWriter 또는 PrintWriter 를 쓴다. 스트림에 있는 객체의 형식화된 표현 텍스트 출력
			PrintWriter pw = new PrintWriter(osw);
			pw.print("너 아이피" + inet.getHostAddress() + " 이지 ? ");
			
			// 8  앞에 있는 내용들 - 버퍼를 비움 
			pw.flush();
			// 13. 
			// 호스트가 보낸 문자를 받기 위한 InputStream 객체가 있어야 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String sendData = br.readLine(); // 클라이언트가 보낸 문자 를 받는다.
			System.out.println("서버가 받은 문자 -------> " + sendData);
		
		} catch(IOException e) {
			System.out.println("[에러]");
		}
	
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();
	}
}
