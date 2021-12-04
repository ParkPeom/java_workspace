package Proxy패턴;

import java.util.ArrayList;

public class MyProgram {
	public static void main(String[] args) {
		
		ArrayList<Thumbnail> thumbnails = new ArrayList<Thumbnail>();
		
		// 이처럼 필요할때만 실제 객체를 생성한다
		// 효율적이고 유연한 프로그래밍이 가능 
		
		thumbnails.add(new ProxyThumbnail("Git 강좌","/git.mp4"));
		thumbnails.add(new ProxyThumbnail("Rest API 란 ? ","/rest-api.mp4"));
		thumbnails.add(new ProxyThumbnail("도커 사용법","/docker.mp4"));
		thumbnails.add(new ProxyThumbnail("객체지향 프로그래밍","/oodp.mp4"));
		thumbnails.add(new ProxyThumbnail("블록체인의 원리","/blockchain.mp4"));
	
		// 하나하나 제목을 표시한다.
		for(Thumbnail thumbnail : thumbnails) {
			thumbnail.showTitle();
		}
		/*
		제목 : Git 강좌
		제목 : Rest API 란 ? 
		제목 : 도커 사용법
		제목 : 객체지향 프로그래밍
		제목 : 블록체인의 원리
		*/
		
		// 마우스를 썸네일에 올릴때 에야 실제 객체 생성 시
		// 한번 RealThumbnail 으로 생성한 썸네일은 다시 영상을 박아 오지 않는다 
		// 이 처럼 필요할 떄만 실제 객체를 생성한다. 보다 효율적인 프로그래밍이 된다.  
		thumbnails.get(2).showPreview();
		thumbnails.get(2).showPreview();
		thumbnails.get(4).showPreview();
		thumbnails.get(1).showPreview();
		
		/*
		/docker.mp4로부터 도커 사용법의 영상 데이터 다운
		도커 사용법의 프리뷰 재생
		도커 사용법의 프리뷰 재생
		/blockchain.mp4로부터 블록체인의 원리의 영상 데이터 다운
		블록체인의 원리의 프리뷰 재생
		/rest-api.mp4로부터 Rest API 란 ? 의 영상 데이터 다운
		Rest API 란 ? 의 프리뷰 재생
		 */
	}
}
