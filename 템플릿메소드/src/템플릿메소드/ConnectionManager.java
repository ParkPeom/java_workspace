package ���ø��޼ҵ�;

import java.util.Map;

// ���ø� �޼ҵ� ������ ������ ������ ���μ����� ���� ���,
// ����ϱ� ���� ������ ����

// ������ ������ ���μ���?
// A->B->C �׻� A�۾� �����ϰ� B�۾� , C�۾��� �����Ѵٸ�
// �� �۾����� �޼ҵ�� ����
// A->B->C ������ ���� �ǵ��� �޼ҵ带 ����

// ���� �α����� �Ѵ�.
// �α����� ���� ������ �Ʒ��� ����.
// 1. ������� ���̵�, ��й�ȣ ��ȣȭ
// 2. ��ȿ�� ���̵�� ��й�ȣ���� Ȯ��
// 3. ���� Ȯ��
// 4. ����

public abstract class ConnectionManager {
	
	// '���� ����'�� ���� 4�ܰ踦 �߻� �޼ҵ�� �����
	// �̶�, 4�ܰ迡 ���� �� �۾��� protected ������ �־� ��� ���� ��ü������ ������ �� �ֵ��� �Ѵ�.
	// requestConnection() �޼ҵ带 ���� �� 4�ܰ踦 ���ʴ�� �����Ѵ�.

	protected abstract Map<String, String> decodedUerInfo(Map<String,String> rawUserInfo);
	protected abstract boolean authentication(String username , String password);
	protected abstract int authorization(String username);
	protected abstract Object getConnection(String username, int authority);
	
	public Object requestConnection(Map<String,String> rawUserInfo) {
		// 1. ��ȣȭ �� ���� ������ ��ȣȭ�Ѵ�.
		final Map<String, String> userInfo = decodedUerInfo(rawUserInfo);
		final String username = userInfo.get("username");
		final String password = userInfo.get("password");
		
		// 2. ���̵�� �н����带 �����Ѵ�.
		if(!authentication(username, password)) {
			throw new RuntimeException("���� ����!");
		}
		
		// 3. ������ Ȯ���Ѵ�.
		final int authority = authorization(username);
		
		return rawUserInfo;
	}
}
