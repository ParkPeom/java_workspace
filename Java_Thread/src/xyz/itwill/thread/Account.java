package xyz.itwill.thread;

//은행 계좌를 저장하기 위한 클래스 
public class Account {

	private int balance;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금 처리 메소드 - 입금자와 입금액을 전달받아 처리 
	/*
	public void deposit(String name,int amount) { // 일반 메소드
		balance+=amount;
		System.out.println("[입금]"+name+"님이"+amount+"원을 입금했습니다. 잔액:"+balance+"원 입니다.");
	}
	*/
	
	//--------------동기화 메소드------------------
	// 스레드가 이 메소드를 실행할때 다른메소드는 락이 걸려있다 
	public synchronized void deposit(String name,int amount) { // 일반 메소드
		balance+=amount;
		System.out.println("[입금]"+name+"님이"+amount+"원을 입금했습니다. 잔액:"+balance+"원 입니다.");
	}
	
	//출금 처리 메소드 - 출금자와 출금액을 전달받아 처리 
	public void withDraw(String name,int amount) {
		if(balance<amount) {//잔액보다 출금액이 많다면.
			System.out.println("[에러]"+name+"님 잔액이 "+balance+"원이 남아서"+amount+"원을 출금할 수 없습니다.");
			return;
		}
		
		balance-=amount;
		System.out.println("[출금]"+name+"님에게"+amount+"원을 출금했습니다. 잔액:"+balance+"원 입니다.");
	}

}
