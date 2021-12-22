package 템플릿메소드;

import java.util.Map;

public class DefaultConnection extends ConnectionManager {
	@Override
	protected Map<String, String> decodedUerInfo(Map<String, String> rawUserInfo) {
		System.out.println("유저 정보 복호화");
		final Map<String,String> encodeUserInfo = rawUserInfo; // 복호화했다고 가정
		return encodeUserInfo;
	}

	@Override
	protected boolean authentication(String username, String password) {
		System.out.println("유저 정보 인증 확인");
		if("hong".equals(username)) {
			return true;
		}
		return false;
	}

	@Override
	protected int authorization(String username) {
		System.out.println("권한 정보 확인");
		// DB에서 권한을 가져온다.
		int authority = 0;
		if("hong".equals(username)) {
			authority = 1;
		}
		// 권한에 따른 작업 수행
		switch(authority) {
		
		case 0:
			System.out.println("- 권한 : 일반 사용자");
			break;
		case 1:
			System.out.println("- 권한 : 관리자");
			break;
		case 2:
			System.out.println("- 권한 : 슈퍼 관리자");
			break;
		default:
			throw new RuntimeException("올바르지 않은 권한!");
		}
		return authority;
	}
		
	@Override
	protected Object getConnection(String username, int authority) {
		System.out.println(username + " 접속 !");
		final Object ConnectionObj = new Object();
		return ConnectionObj; // Connection 객체 반환 
	}
}
