package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {
	
	public SocketTest() {
	
		try {
			// 3.호스트 내 IP 로컬 컴퓨터 
			InetAddress inet = InetAddress.getByName("172.30.1.12");
		
			// 4. 내 ip로 서버에 접속하기 서버 포트는 1000 
			Socket socket = new Socket(inet,1000);
			
			// 9. 서버로부터 메세지를 호스트가 받음 
			// 데이터를 받기 위해 InputStream read() 호출 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String receive = br.readLine();
			System.out.println(receive);
			
			// 10 . 클라이언트(호스트)가 서버로 데이터 보내기 - 문자 단위로 보냄 
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			
			// 11. 호스트가 서버로 문자 보내기
			pw.print("안녕하세요 서버님");
			pw.print("처음뵙겠습니다.");

			// 12 정석 대로 종료 
			pw.flush();
			pw.close();
		} catch (UnknownHostException u) {
			System.out.println(" [에러] ");
		} catch (IOException e) {
			System.out.println(" [에러] ");
		}
	}
}
