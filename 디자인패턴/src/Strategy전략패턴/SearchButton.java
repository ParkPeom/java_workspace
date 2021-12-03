package Strategy��������;

public class SearchButton {
	
	private MyProgram myProgram;
	
	public SearchButton(MyProgram _myProgram) {
		myProgram = _myProgram;
	}
	// �� �ڰ����� ���� Ŭ���� ��ü�� SearchStrateg�� search�� ���Ե� 
	// ������ �˻� �ʱ�ȭ�� �Ǿ� ������ 
	// setter�� �̿��Ͽ� ������ SearchStrategy �� ���� �������̽� ����
	// �ٸ� �˻� �������� ���� ����� �ִ�. 
	private SearchStrategy searchStrategy = new SearchStratagyAll();
	
	public void setSearchStrategy(SearchStrategy _searchStrategy) {
		searchStrategy = _searchStrategy;
	}
	
	public void onClick() {
		searchStrategy.search();
	}
}
