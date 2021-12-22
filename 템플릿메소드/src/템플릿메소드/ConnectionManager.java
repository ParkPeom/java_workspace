package 템플릿메소드;

import java.util.Map;

// 템플릿 메소드 패턴은 일정한 구조의 프로세스를 가진 경우,
// 사용하기 좋은 디자인 패턴

// 일정한 구조의 프로세서?
// A->B->C 항상 A작업 수행하고 B작업 , C작업을 수행한다면
// 각 작업들을 메소드로 구현
// A->B->C 순으로 실행 되도록 메소드를 구현

// 계정 로그인을 한다.
// 로그인의 동작 순서는 아래와 같다.
// 1. 사용자의 아이디, 비밀번호 복호화
// 2. 유효한 아이디와 비밀번호인지 확인
// 3. 권한 확인
// 4. 접속

public abstract class ConnectionManager {
	
	// '계정 접속'을 위한 4단계를 추상 메소드로 만든다
	// 이때, 4단계에 대한 각 작업은 protected 권한을 주어 상속 받은 객체에서만 구현할 수 있도록 한다.
	// requestConnection() 메소드를 통해 위 4단계를 차례대로 수행한다.

	protected abstract Map<String, String> decodedUerInfo(Map<String,String> rawUserInfo);
	protected abstract boolean authentication(String username , String password);
	protected abstract int authorization(String username);
	protected abstract Object getConnection(String username, int authority);
	
	public Object requestConnection(Map<String,String> rawUserInfo) {
		// 1. 암호화 된 유저 정보를 복호화한다.
		final Map<String, String> userInfo = decodedUerInfo(rawUserInfo);
		final String username = userInfo.get("username");
		final String password = userInfo.get("password");
		
		// 2. 아이디와 패스워드를 인증한다.
		if(!authentication(username, password)) {
			throw new RuntimeException("인증 실패!");
		}
		
		// 3. 권한을 확인한다.
		final int authority = authorization(username);
		
		return rawUserInfo;
	}
}
