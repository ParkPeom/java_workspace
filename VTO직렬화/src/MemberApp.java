import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MemberApp {

	public MemberApp() {
	
	}
	
	public static void main(String[] args) throws IOException {
		
		MemberDTO member = new MemberDTO("�ڹ�","zkokopo@naver.com",28);
		
		byte[] serializedMember;
		
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(member);
				// serializedMember -> ����ȭ�� member ��ü
				serializedMember = baos.toByteArray();
			}
		}
		// ����Ʈ �迭�� ������ ����ȭ �����͸� base64�� ��ȯ
		System.out.println();
	}
}
