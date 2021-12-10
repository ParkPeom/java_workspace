import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Socket : TCP ����� ��Ʈ��ũ ���α׷� ���� Ŭ���̾�Ʈ�� �����ϱ� ���� Ŭ����
// => ������ ��ǻ�� �̸��� ��Ʈ��ũ �ּ� �� Ŭ���̾�Ʈ(���� ��ǻ��)�� ��Ʈ��ũ �ּ� ����
// => ������ �����Ͽ� ���� �����ϰų� ���޹��� �� �ִ� �ν��Ͻ��� �����ϱ� ���� Ŭ����
// => ������ Ŭ���̾�Ʈ(���� ��ǻ��)�� ��ǻ�� �̸��� ��ũ��ũ �ּ� �� ��Ʈ��ȣ ���� 
// => ���ӵ� ��ǻ�� ���� ���� �ְ� �ޱ� ���� �Է� ��Ʈ���� ��½�Ʈ���� �ڵ� ���� �Ǿ� ����

public class SocketApp {
	
	public static void main(String[] args) {
		try {
			//Socket(String host,int port) : ���� ��ǻ���� �̸� �Ǵ� ��Ʈ��ũ �ּҿ� ��Ʈ 
			//��ȣ�� ���޹޾� ������ ���ӵ� socket �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ� 
			Socket socket = new Socket("www.daum.net",80);
			
			// Skcket �ν��Ͻ��� ����� ���� ������ ���ڿ��� ��ȯ�Ͽ� ��ȯ 
			System.out.println("socktet = " + socket);
			
			// Socket �ν��Ͻ��� ����� ���� ��ǻ��(����)�� ��ǻ����
			// �̸��� ��Ʈ��ũ �ּҰ� ����� InetAddress �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Remote IP Address = " + socket.getInetAddress().getHostAddress());
			// Socket �ν��Ͻ��� ����� ���� ��ǻ��(����)�� ��Ʈ��ȣ�� ��ȯ 
			System.out.println("Remote Port Number = " + socket.getPort());
		
			// ���� ��ǻ��(Ŭ���̾�Ʈ)�� ��ǻ�� �̸��� ��Ʈ��ũ �ּҰ� ����� InetAddress �ν��Ͻ� ��ȯ
			System.out.println(socket.getLocalAddress().getHostAddress());
			
			// ���� ��ǻ���� ��Ʈ��ȣ�� ��ȯ�ϴ� �޼ҵ�
			System.out.println(socket.getLocalPort());
			
			//Socket.close() : ������ �����ϴ� �޼ҵ� - ���� ���� 
			socket.close();
			
		} catch(UnknownHostException e) {
			System.out.println("[����]���� ��ǻ�͸� ã�� �� �����ϴ�.");
		} catch(IOException e) {
			System.out.println("[����]������ ������ �� �����ϴ�.");
		}
		
	}
}
