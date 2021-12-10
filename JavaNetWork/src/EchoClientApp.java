import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Ű����� �޼����� �Է¹޾� ������ �����Ͽ� ���� ������ �޼����� �����ϴ� Ŭ���̾�Ʈ ���α׷���
public class EchoClientApp {
	
	public static void main(String[] args) throws IOException {
		
		// Ű����� �Է¹����� Ȯ����Ѽ� ���ڿ��� �Է¹���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���� �޼��� �Է�  >> ");
		String message = br.readLine();
		
		try {
			Socket socket = new Socket("172.31.98.131",5000);	
			
			/*
			// ��뷮 ��Ʈ������ Ȯ�� 
			// ������ ��� ��Ʈ���� ��ȯ�޾� ���ڿ��� ������ �� �ֵ��� Ȯ����״�. 
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//BufferedWriter.write(String str) : ��½�Ʈ���� �̿��Ͽ� ���ڿ��� �����ϴ� �޼ҵ� 
			out.write(message);
			//BufferedWriter.flush() : ��½�Ʈ���� ����(�ӽø޸�)�� �����ϴ� ��� ���ڿ��� �����ϴ� �޼ҵ�
			out.flush();
			*/
			
			// ������ �����Ʈ���� ��ȯ�޾� ��� �ڷ����� ���� ���ڿ��� ������ �� �ֵ��� Ȯ��
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(message);
			out.flush();
			
			socket.close();
		} catch(Exception e) {
			System.out.print("[����]������ ���� �� �� �����ϴ�.");
		}
	}
}
