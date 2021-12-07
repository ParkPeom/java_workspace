import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.itwill.jdbc.ConnectionFactory;

// ���ӵ� DBMS ������ SQL ����� �����Ͽ� ����� ����� ��ȯ�ϴ� ����� ����
// => PreparedStatement �ν��Ͻ��� SQL ����� �̸� �����Ͽ� ���ӵ� DBMS ������ �����Ͽ� ���� 
// ���� :InParameter�� �̿��Ͽ� ���� ���޹޾� SQL����� �ۼ� 
// => InParameter�� ����Ͽ� �������� ���������� ȿ���� ���� 
// => InSQL ��ŷ ��� ��ȿȭ ó�� - ����� �Է°��� ������ SQL ����� ������ ó�� 
// ���� :PreparedStatement �ν��Ͻ��� �ϳ��� SQL ��ɸ��� �����Ͽ� ���� ���� 
public class PreparedStatementApp {
	
	public static void main(String[] args) throws IOException , SQLException {
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է½�Ʈ�� ���� 			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		//Ű����� �л������� �Է¹޾� ������ ����
		System.out.println("<<�л����� �Է�>>\n");
		System.err.print(" �й� �Է� >>");
		// Integer.parseInt(String s) : ���ڿ��� ���޹޾� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼���
		//=>NumberFormatException �߻� - ���޹��� ���ڿ��� ������ ������ �ƴ� ��� �߻�) �߻� ����
		// '���� x "123" -> 123 
		int num = Integer.parseInt(br.readLine());
		System.out.print("�̸� �Է� >> ");
		String name = br.readLine();
		System.out.print("��ȭ��ȣ �Է� >> ");
		String phone = br.readLine();
		System.out.print("�ּ� �Է� >> ");
		String address = br.readLine();
		System.out.print("������� �Է� >> ");
		String birthday = br.readLine();
		System.out.println("============================================");
		
		//Ű����� �Էµ� �л������� STUDENT ���̺��� ������ �����Ͽ� ����
		Connection con = ConnectionFactory.getConnection();
		
		// SQL���� �̸� ������ ��
		// Connection.prepareStatement(String sql) : ���ӵ� DBMS ������ ������ SQL�����
		// ������ PreparedStatement �ν��Ͻ��� ��ȯ�ϴ� �޼��� 
		// => PreparedStatement �ν��Ͻ��� ����� SQL ��ɿ����� ? ��ȣ�� ��� 
		// ����ǥ��� �����ʰ� (InParameter) �Է¸Ű����� or �Է� ���� ��� �θ���.
		// InParameter(?) : Java �������� �����޾� SQL ����� ������ ǥ���ϱ� ���� ��ȣ 
		// => PreparedStatement �ν��Ͻ��� ����� SQL ����� ��� InParameter ���� �ݵ��
		//	Java �������� ���� �Ǿ�߸� SQL����� �ϼ��Ǿ� ���� DBMS ������ ���� ���� 
		//PreparedStatement.setXXX(int parameterIndex, XXX value)
		// => ���ϴ� ��ġ(OracleIndex)��  InParameter �� Java�������� �����ϴ� �޼��� 
		// => xxx�� Java �ڷ����� ǥ���ϸ� �޼���� InParameter �� ������ŭ ȣ�� 
		String sql = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);		
		pstmt.setInt(1, num);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		// PreparedStatement.executeUpdate : PreparedStatement �ν��Ͻ��� ����� �ϼ��� SQL
		// ���(INSERT,UPDATE,DELETE)�� �����ϴ� �޼��� - �������� ����(int) ��ȯ 
		int rows = pstmt.executeUpdate();
		
		System.out.println("[���]"+rows+"���� �л� ������ �����Ͽ����ϴ�.");

		// STUDENT���̺꿡 ����� ��� �л������� �˻��Ͽ� ���
		String sql2 =  "select * from student order by no ";
		
		pstmt = con.prepareStatement(sql2);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("no"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getString("birthday"));
		}
		
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �л������� �Է¹޾� ������ ����
		System.out.println("<<�л����� �Է�>>\n");
		System.err.print(" �̸� �Է� >>");
		name = br.readLine();
		System.out.println("===========================================");
		con = ConnectionFactory.getConnection();
		
		// InParameter�� Java �������� ������ SQL����� �����θ� ó��
		String sql3 = "select * from student where name = ? order by no";
		pstmt = con.prepareStatement(sql3);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("no"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getString("birthday"));
		}
	}
}
