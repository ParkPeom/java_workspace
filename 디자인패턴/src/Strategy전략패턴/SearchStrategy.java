package Strategy��������;

public interface SearchStrategy {
	public void search();
}


// ������ �˻������� ������ �˻����� ���� ����� �ִ�. 
class SearchStratagyAll implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH ALL");
		//��ü �˻� �ϴ� �ڵ� 
	}
}
class SearchStratagyImage implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH IMAGE");
		// �̹����˻��ϴ� �ڵ�
	}
}
class SearchStrategyNews implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH NEWS");
		// ���� �˻��ϴ� �ڵ� 
	}
}
class SearchStrategyMap implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH MAP");
		//���� �˻��ϴ� �ڵ� 
	}
}