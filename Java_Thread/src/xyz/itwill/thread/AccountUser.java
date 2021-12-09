package xyz.itwill.thread;

//은행계좌에 사용자 정보(은행계좌정보,사용자명)를 저장하기 위한 클래스 
// => 은행계좌에 입출금을 독립적으로 할수 있도록 Thread 클래스 를 상속받아 작성 
public class AccountUser extends Thread {
	private Account account; //은행계좌정보 - 포함 관계
	private String userName;
	
	public AccountUser() {
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	// 독립적으로 입출금을 할수있도록 
	// 사용자가 입금 또는 출금하는 명령이 작성된 메소드
	// => 새롭게 생성된 스레드에 의해 명령 실행
	@Override
	public void run() {
		// account.deposit(userName, 5000); // 은행 계좌에 입금 
		// account.withDraw(userName, 5000); // 출금
	
		 //synchronized 키워드를 생성된 동기화 영역 
		 // => 동기화 처리하기 위한 인스턴스
		 synchronized(account) {
			 account.withDraw(userName, 5000);
		 }
	
	}
}
