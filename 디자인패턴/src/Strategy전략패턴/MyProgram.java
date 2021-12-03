package Strategy��������;

public class MyProgram {
	
	// �ɼǵ鸶�� �ൿ���� ���ȭ �ؼ� �������̰�
	// ��ȣ ��ü���� �����ϰ� ����� ���� 
	// strategy ���������̴�.
	
	
	private SearchButton searchButton = new SearchButton(this);
	
	public void setModeAll() {
		searchButton.setSearchStrategy(new SearchStratagyAll());
	}
	
	public void setModeImage() {
		searchButton.setSearchStrategy(new SearchStratagyImage());
	}
	
	public void setModeNews() {
		searchButton.setSearchStrategy(new SearchStrategyNews());
	}
	
	public void setModeMap() {
		searchButton.setSearchStrategy(new SearchStrategyMap());
	}
	
	public void testProgram() {
		searchButton.onClick(); // "SEARCH ALL" ���
		setModeImage(); 		// �̹��� �˻� ����
		searchButton.onClick();
		setModeNews();
		searchButton.onClick(); 
		setModeMap();			// �����˻� ����
		searchButton.onClick(); // SEARCH MAP ��� 
	}
	
}
