package Proxy패턴;

public interface Thumbnail {
	public void showTitle();
	public void showPreview();
}

// 실제 클래스 
class RealThumbnail implements Thumbnail {
	private String title;
	private String movieUrl;
	
	public RealThumbnail(String _title , String _movieUrl) {
		title = _title;
		movieUrl = _movieUrl;
		System.out.println(movieUrl + "로부터 " + title +"의 영상 데이터 다운");
	}
	@Override
	public void showTitle() {
		System.out.println("제목 : " + title);
	}
	@Override
	public void showPreview() {
		System.out.println(title + "의 프리뷰 재생");
	}	
}

// 대리인 클래스 
class ProxyThumbnail implements Thumbnail {
	private String title;
	private String movieUrl;
	
	private RealThumbnail realThumbnail;

	public ProxyThumbnail(String title, String movieUrl) {
		this.title = title;
		this.movieUrl = movieUrl;
	}
	
	public void showTitle() {
		System.out.println("제목 : " + title);
	}
	
	public void showPreview() {
		if(realThumbnail == null) {
			realThumbnail = new RealThumbnail(title,movieUrl);
	}
	realThumbnail.showPreview();	
	}
}
