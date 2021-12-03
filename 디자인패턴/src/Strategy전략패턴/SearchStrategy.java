package Strategy전략패턴;

public interface SearchStrategy {
	public void search();
}


// 각각의 검색전략을 각각의 검색으로 갈아 끼울수 있다. 
class SearchStratagyAll implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH ALL");
		//전체 검색 하는 코드 
	}
}
class SearchStratagyImage implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH IMAGE");
		// 이미지검색하는 코드
	}
}
class SearchStrategyNews implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH NEWS");
		// 뉴스 검색하는 코드 
	}
}
class SearchStrategyMap implements SearchStrategy {
	public void search() {
		System.out.println("SEARCH MAP");
		//지도 검색하는 코드 
	}
}