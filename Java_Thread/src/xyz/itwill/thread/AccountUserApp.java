package xyz.itwill.thread;

public class AccountUserApp {
	public static void main(String[] args) {
		Account account = new Account(10000);//은행계좌 생성 - 잔액 : 10000
		System.out.println("잔액 = " + account.getBalance() + "원");
		System.out.println("====================================");		
		AccountUser[] users = new AccountUser[3];
		// 배열에 넣음 
		// 우선순위를 안해주면 모두 우선순위가 5다 
		users[0] = new AccountUser(account,"홍길동");
		users[1] = new AccountUser(account,"임꺽정");
		users[2] = new AccountUser(account,"전우치");
		
		//단일스레드를 이용하여 모든 사용자의 입금 처리
		// 배열 출력 
		for(AccountUser user : users) {
			// 단일 스레드를 이용하여 모든 사용자의 입금 처리	
			// => 배열 요소 순서대로 순차적으로 입금 처리 
			// user.getAccount().deposit(user.getUserName() , 5000);
			
			// 다중 스레드를 이용하여 모든 사용자의 입금(출금) 처리
			// => 서로 다른 스레드를 이용하여 비순차적인 입금 처리 
			// 다중스레드가 공유 데이타를 처리하는 메소드를 호출할 경우 결과가 비정상적인 결과 발생
			// => 입금 또는 출금 메소드를 호출한 경우 은행계좌의 잔액(공유데이타) 처리에 문제 발생 
			// 해결법 ) 다중 스레드의 공유 데이타 처리에 문제점을 해결하는 방법
			//=>스레드 동기화 (Thread Synchronized) : 다중 스레드에서 호출되는 공유데이타를 처리
			// 하는 메소드를 가장먼저 호출한 스레드가 메소드의 명령을 모두 실행하기 전까지 다른 스레드에 의해 호출
			// 되지 않도록 스레드를 일시적으로 중지(대기상태 - Thread Lock)
			
			//스레드 동기화 처리 방법
			//1.공유 데이타를 처리하는 메소드를 동기화 메소드로 선언
			// => 메소드 작성 시 Synchronized 키워드를 사용하여 메소드 선언 
			//2.동기화 영역에서 공유데이타를 처리하는 메소드를 호출
			// => 메소드를 호출하는 명령을 동기화 처리된 영역에서 호출 
			// synchronized 키워드로 작성된 동기화 영역에서 메소드 호출
			user.start();//새로운 스레드를 생성하여 run() 메소드에서- 입금(출금) 처리 
		}
		
	}
}
