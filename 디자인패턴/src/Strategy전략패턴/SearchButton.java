package Strategy전략패턴;

public class SearchButton {
	
	private MyProgram myProgram;
	
	public SearchButton(MyProgram _myProgram) {
		myProgram = _myProgram;
	}
	// 이 자격증이 가진 클래스 객체가 SearchStrateg의 search에 대입됨 
	// 생성시 검색 초기화가 되어 있지만 
	// setter를 이용하여 언제든 SearchStrategy 를 입은 인터페이스 입은
	// 다른 검색 전략으로 갈아 끼울수 있다. 
	private SearchStrategy searchStrategy = new SearchStratagyAll();
	
	public void setSearchStrategy(SearchStrategy _searchStrategy) {
		searchStrategy = _searchStrategy;
	}
	
	public void onClick() {
		searchStrategy.search();
	}
}
