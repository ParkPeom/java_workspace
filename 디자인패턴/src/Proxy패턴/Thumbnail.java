package Proxy����;

public interface Thumbnail {
	public void showTitle();
	public void showPreview();
}

// ���� Ŭ���� 
class RealThumbnail implements Thumbnail {
	private String title;
	private String movieUrl;
	
	public RealThumbnail(String _title , String _movieUrl) {
		title = _title;
		movieUrl = _movieUrl;
		System.out.println(movieUrl + "�κ��� " + title +"�� ���� ������ �ٿ�");
	}
	@Override
	public void showTitle() {
		System.out.println("���� : " + title);
	}
	@Override
	public void showPreview() {
		System.out.println(title + "�� ������ ���");
	}	
}

// �븮�� Ŭ���� 
class ProxyThumbnail implements Thumbnail {
	private String title;
	private String movieUrl;
	
	private RealThumbnail realThumbnail;

	public ProxyThumbnail(String title, String movieUrl) {
		this.title = title;
		this.movieUrl = movieUrl;
	}
	
	public void showTitle() {
		System.out.println("���� : " + title);
	}
	
	public void showPreview() {
		if(realThumbnail == null) {
			realThumbnail = new RealThumbnail(title,movieUrl);
	}
	realThumbnail.showPreview();	
	}
}
