package Strategy전략패턴;

public class MyProgram {
	
	// 옵션들마다 행동들을 모듈화 해서 독립적이고
	// 상호 교체적인 가능하게 만드는 것이 
	// strategy 전략패턴이다.
	
	
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
		searchButton.onClick(); // "SEARCH ALL" 출력
		setModeImage(); 		// 이미지 검색 모드로
		searchButton.onClick();
		setModeNews();
		searchButton.onClick(); 
		setModeMap();			// 지도검색 모드로
		searchButton.onClick(); // SEARCH MAP 출력 
	}
	
}
