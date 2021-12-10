import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//������ �����Ͽ� �������� ������ ��¥�� �ð��� �޾� ����ϴ� Ŭ���̾�Ʈ ���α׷�
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket �ν��Ͻ� ���� - ���� ����
			Socket socket=new Socket("172.31.98.131", 3000);
			
			//Socket.getInputStream() : Socket �ν��Ͻ��� �Է½�Ʈ��(InputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
			// => ���ӵ� ��ǻ�Ϳ��� ������ ���� ����Ÿ(1Byte)�� ���޹޴� �Է½�Ʈ��
			InputStream in=socket.getInputStream();
			
			//Socket �ν��Ͻ��� �Է½�Ʈ���� ���޹޾� ��ü�� ���޹��� �� �ִ� �Է½�Ʈ������ Ȯ���Ͽ� ����
			ObjectInputStream stream=new ObjectInputStream(in);
			
			//ObjectInputStream.readObject() : �Է½�Ʈ���� �̿��Ͽ� ��ü(�ν��Ͻ�)�� ���޹޴� �޼ҵ�
			// => Object Ÿ������ �ν��Ͻ��� ��ȯ�ǹǷ� ����� ��ü ����ȯ�Ͽ� ���������� ����
			Date date=(Date)stream.readObject();
			
			//Date �ν��Ͻ��� ����� ��¥�� �ð��� ���ϴ� ������ ���ڿ��� ��ȯ�޾� ���
			System.out.println("[���]�������� ������ ��¥�� �ð� = "
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			
			//���� ����
			socket.close();
		} catch (IOException e) {
			System.out.println("[����]������ ������ �� �����ϴ�.");
		}
	}
}