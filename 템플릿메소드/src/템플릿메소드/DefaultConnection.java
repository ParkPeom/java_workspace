package ���ø��޼ҵ�;

import java.util.Map;

public class DefaultConnection extends ConnectionManager {
	@Override
	protected Map<String, String> decodedUerInfo(Map<String, String> rawUserInfo) {
		System.out.println("���� ���� ��ȣȭ");
		final Map<String,String> encodeUserInfo = rawUserInfo; // ��ȣȭ�ߴٰ� ����
		return encodeUserInfo;
	}

	@Override
	protected boolean authentication(String username, String password) {
		System.out.println("���� ���� ���� Ȯ��");
		if("hong".equals(username)) {
			return true;
		}
		return false;
	}

	@Override
	protected int authorization(String username) {
		System.out.println("���� ���� Ȯ��");
		// DB���� ������ �����´�.
		int authority = 0;
		if("hong".equals(username)) {
			authority = 1;
		}
		// ���ѿ� ���� �۾� ����
		switch(authority) {
		
		case 0:
			System.out.println("- ���� : �Ϲ� �����");
			break;
		case 1:
			System.out.println("- ���� : ������");
			break;
		case 2:
			System.out.println("- ���� : ���� ������");
			break;
		default:
			throw new RuntimeException("�ùٸ��� ���� ����!");
		}
		return authority;
	}
		
	@Override
	protected Object getConnection(String username, int authority) {
		System.out.println(username + " ���� !");
		final Object ConnectionObj = new Object();
		return ConnectionObj; // Connection ��ü ��ȯ 
	}
}
