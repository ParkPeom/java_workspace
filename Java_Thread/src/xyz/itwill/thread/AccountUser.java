package xyz.itwill.thread;

//������¿� ����� ����(�����������,����ڸ�)�� �����ϱ� ���� Ŭ���� 
// => ������¿� ������� ���������� �Ҽ� �ֵ��� Thread Ŭ���� �� ��ӹ޾� �ۼ� 
public class AccountUser extends Thread {
	private Account account; //����������� - ���� ����
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
	
	// ���������� ������� �Ҽ��ֵ��� 
	// ����ڰ� �Ա� �Ǵ� ����ϴ� ����� �ۼ��� �޼ҵ�
	// => ���Ӱ� ������ �����忡 ���� ��� ����
	@Override
	public void run() {
		// account.deposit(userName, 5000); // ���� ���¿� �Ա� 
		// account.withDraw(userName, 5000); // ���
	
		 //synchronized Ű���带 ������ ����ȭ ���� 
		 // => ����ȭ ó���ϱ� ���� �ν��Ͻ�
		 synchronized(account) {
			 account.withDraw(userName, 5000);
		 }
	
	}
}
