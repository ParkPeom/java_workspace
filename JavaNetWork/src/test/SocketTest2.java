package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest2 {
	
	public SocketTest2() {
		try {
			InetAddress ia = InetAddress.getByName("172.30.34.113");
			Socket s = new Socket(ia,2000);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String receive = br.readLine(); // String 반환 
			System.out.println("받은 메세지 : " + receive);
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			pw.print("안녕하세요");
			pw.flush();
			pw.close();
			
		} catch (UnknownHostException e) {
			System.out.println("[에러] IP 정보가 없습니다.");
		} catch (IOException ioe) {
			System.out.println("[에러] IP 정보가 없습니다.");
		}
	}
	public static void main(String[] args) {
		new SocketTest2();
	}
}
