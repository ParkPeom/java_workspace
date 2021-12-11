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
			// 3.ȣ��Ʈ �� IP ���� ��ǻ�� 
			InetAddress inet = InetAddress.getByName("172.30.1.12");
		
			// 4. �� ip�� ������ �����ϱ� ���� ��Ʈ�� 1000 
			Socket socket = new Socket(inet,1000);
			
			// 9. �����κ��� �޼����� ȣ��Ʈ�� ���� 
			// �����͸� �ޱ� ���� InputStream read() ȣ�� 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String receive = br.readLine();
			System.out.println(receive);
			
			// 10 . Ŭ���̾�Ʈ(ȣ��Ʈ)�� ������ ������ ������ - ���� ������ ���� 
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			
			// 11. ȣ��Ʈ�� ������ ���� ������
			pw.print("�ȳ��ϼ��� ������");
			pw.print("ó���˰ڽ��ϴ�.");

			// 12 ���� ��� ���� 
			pw.flush();
			pw.close();
		} catch (UnknownHostException u) {
			System.out.println(" [����] ");
		} catch (IOException e) {
			System.out.println(" [����] ");
		}
	}
}
