import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MemberApp {

	public MemberApp() {
	
	}
	
	public static void main(String[] args) throws IOException {
		
		MemberDTO member = new MemberDTO("박범","zkokopo@naver.com",28);
		
		byte[] serializedMember;
		
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(member);
				// serializedMember -> 직렬화된 member 객체
				serializedMember = baos.toByteArray();
			}
		}
		// 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
		System.out.println();
	}
}
