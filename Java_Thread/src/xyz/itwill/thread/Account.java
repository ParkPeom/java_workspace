package xyz.itwill.thread;

//���� ���¸� �����ϱ� ���� Ŭ���� 
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
	
	//�Ա� ó�� �޼ҵ� - �Ա��ڿ� �Աݾ��� ���޹޾� ó�� 
	/*
	public void deposit(String name,int amount) { // �Ϲ� �޼ҵ�
		balance+=amount;
		System.out.println("[�Ա�]"+name+"����"+amount+"���� �Ա��߽��ϴ�. �ܾ�:"+balance+"�� �Դϴ�.");
	}
	*/
	
	//--------------����ȭ �޼ҵ�------------------
	// �����尡 �� �޼ҵ带 �����Ҷ� �ٸ��޼ҵ�� ���� �ɷ��ִ� 
	public synchronized void deposit(String name,int amount) { // �Ϲ� �޼ҵ�
		balance+=amount;
		System.out.println("[�Ա�]"+name+"����"+amount+"���� �Ա��߽��ϴ�. �ܾ�:"+balance+"�� �Դϴ�.");
	}
	
	//��� ó�� �޼ҵ� - ����ڿ� ��ݾ��� ���޹޾� ó�� 
	public void withDraw(String name,int amount) {
		if(balance<amount) {//�ܾ׺��� ��ݾ��� ���ٸ�.
			System.out.println("[����]"+name+"�� �ܾ��� "+balance+"���� ���Ƽ�"+amount+"���� ����� �� �����ϴ�.");
			return;
		}
		
		balance-=amount;
		System.out.println("[���]"+name+"�Կ���"+amount+"���� ����߽��ϴ�. �ܾ�:"+balance+"�� �Դϴ�.");
	}

}
