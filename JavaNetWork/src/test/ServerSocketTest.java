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
			// 1. ���� ����
			ServerSocket servertest = new ServerSocket(1000);
			// 2. �������� ����ڵ��� ������ ��� 
			Socket s = servertest.accept();
			
			// 5. ȣ��Ʈ ip ������
			InetAddress inet = s.getInetAddress(); // 6. ���ӵ� ȣ��Ʈ IP ������ 
			System.out.println(inet.getHostAddress() + "---> Ŭ���̾�Ʈ ���� �߽��ϴ�.");
			
			// 7. �������� ȣ��Ʈ���� �޼���
			// byte[] �迭 �����ϰ� �̰��� �Ű��� -> OutputStream write() �޼��� ȣ��
			// 2����Ʈ �� �ѱ۷� ���� OutputStreamWriter
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			// getOutputStream 1����Ʈ �迭 - ������ OutputStreamWriter 2����Ʈ��(�ѱ� �������)
			
			// ���⼭ BufferedWriter �Ǵ� PrintWriter �� ����. ��Ʈ���� �ִ� ��ü�� ����ȭ�� ǥ�� �ؽ�Ʈ ���
			PrintWriter pw = new PrintWriter(osw);
			pw.print("�� ������" + inet.getHostAddress() + " ���� ? ");
			
			// 8  �տ� �ִ� ����� - ���۸� ��� 
			pw.flush();
			// 13. 
			// ȣ��Ʈ�� ���� ���ڸ� �ޱ� ���� InputStream ��ü�� �־�� �Ѵ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String sendData = br.readLine(); // Ŭ���̾�Ʈ�� ���� ���� �� �޴´�.
			System.out.println("������ ���� ���� -------> " + sendData);
		
		} catch(IOException e) {
			System.out.println("[����]");
		}
	
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();
	}
}
