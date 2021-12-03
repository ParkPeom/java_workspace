package Proxy����;

import java.util.ArrayList;

public class MyProgram {
	public static void main(String[] args) {
		
		ArrayList<Thumbnail> thumbnails = new ArrayList<Thumbnail>();
		
		// ��ó�� �ʿ��Ҷ��� ���� ��ü�� �����Ѵ�
		// ȿ�����̰� ������ ���α׷����� ���� 
		
		thumbnails.add(new ProxyThumbnail("Git ����","/git.mp4"));
		thumbnails.add(new ProxyThumbnail("Rest API �� ? ","/rest-api.mp4"));
		thumbnails.add(new ProxyThumbnail("��Ŀ ����","/docker.mp4"));
		thumbnails.add(new ProxyThumbnail("��ü���� ���α׷���","/oodp.mp4"));
		thumbnails.add(new ProxyThumbnail("���ü���� ����","/blockchain.mp4"));
	
		for(Thumbnail thumbnail : thumbnails) {
			thumbnail.showTitle();
		}
		/*
		���� : Git ����
		���� : Rest API �� ? 
		���� : ��Ŀ ����
		���� : ��ü���� ���α׷���
		���� : ���ü���� ����
		*/
		
		thumbnails.get(2).showPreview();
		thumbnails.get(2).showPreview();
		thumbnails.get(4).showPreview();
		thumbnails.get(1).showPreview();
		
		/*
		/docker.mp4�κ��� ��Ŀ ������ ���� ������ �ٿ�
		��Ŀ ������ ������ ���
		��Ŀ ������ ������ ���
		/blockchain.mp4�κ��� ���ü���� ������ ���� ������ �ٿ�
		���ü���� ������ ������ ���
		/rest-api.mp4�κ��� Rest API �� ? �� ���� ������ �ٿ�
		Rest API �� ? �� ������ ���
		 */
	}
}
