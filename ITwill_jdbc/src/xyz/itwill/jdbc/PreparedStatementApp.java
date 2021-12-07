package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//PreparedStatement : ���ӵ� DBMS ������ SQL ����� �����Ͽ� ����� ����� ��ȯ�ϴ� ����� �����ϴ� �ν��Ͻ�
// => PreparedStatement �ν��Ͻ��� SQL ����� �̸� �����Ͽ� ���ӵ� DBMS ������ �����Ͽ� ����
//���� : InParameter�� �̿��Ͽ� ���� ���޹޾� SQL ����� �ۼ�
// => InParameter�� ����Ͽ� �������� ���������� ȿ���� ����
// => InSQL ��ŷ ��� ��ȿȭ ó�� - ����� �Է°��� ������ SQL ����� ������ ó��
//���� : PreparedStatement �ν��Ͻ��� �ϳ��� SQL ��ɸ��� �����Ͽ� ���� ����
public class PreparedStatementApp {
	public static void main(String[] args) throws IOException, SQLException {
		/*
		//Ű����� �л������� �Է¹޾� STUDENT ���̺� �����Ͽ� �����ϰ� ����� ��� 
		//�л������� �˻��Ͽ� ����ϴ� JDBC ���α׷�
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է½�Ʈ�� ����
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �л������� �Է¹޾� ������ ����
		System.out.println("<<�л����� �Է�>>");
		System.out.print("�й� �Է� >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.print("�̸� �Է� >> ");
		String name=in.readLine();
		System.out.print("��ȭ��ȣ �Է� >> ");
		String phone=in.readLine();
		System.out.print("�ּ� �Է� >> ");
		String address=in.readLine();
		System.out.print("������� �Է� >> ");
		String birthday=in.readLine();
		System.out.println("==============================================================");
		//Ű����� �Էµ� �л������� STUDENT ���̺��� ������ �����Ͽ� ����
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : ���ӵ� DBMS ������ ������ SQL �����
		//������ PreparedStatement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => PreparedStatement �ν��Ͻ��� ����� SQL ��ɿ����� ?(InParameter) ��ȣ ���
		//InParameter : Java �������� �����޾� SQL ����� ������ ǥ���ϱ� ���� ��ȣ
		// => PreparedStatement �ν��Ͻ��� ����� SQL ����� ��� InParameter���� �ݵ�� 
		//    Java �������� ���޵Ǿ�߸� SQL ����� �ϼ��Ǿ� ���� DBMS ������ ���� ����
		//PreparedStatement.setXXX(int parameterIndex, XXX value)
		// => ���ϴ� ��ġ(parameterIndex - OracleIndex)�� InParameter�� Java �������� �����ϴ� �޼ҵ�
		// => XXX�� Java �ڷ����� ǥ���ϸ� �޼ҵ�� InParameter�� ������ŭ ȣ��
		String sql1="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : PreparedStatement �ν��Ͻ��� ����� �ϼ��� SQL
		//���(INSERT,UPDATE,DELETE)�� �����ϴ� �޼ҵ� - �������� ����(int) ��ȯ
		int rows=pstmt.executeUpdate();
		
		System.out.println("[���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		System.out.println("==============================================================");
		//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ���
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		//PreparedStatement.executeQuery() : PreparedStatement �ν��Ͻ��� ����� �ϼ��� SQL
		//���(SELECT)�� �����ϴ� �޼ҵ� - ResultSet �ν��Ͻ�(�˻����) ��ȯ
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<�л���� ���>>");
		while(rs.next()) {
			System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("==============================================================");
		*/
		
		//Ű����� �̸��� �Է¹޾� STUDENT ���̺� ����� �л����� �� �Է� �̸��� ���� 
		//�̸��� �л������� �˻��Ͽ� ����ϴ� JDBC ���α׷�
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է½�Ʈ�� ����
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �̸��� �Է¹޾� ����
		System.out.println("<<�л����� �˻�>>");
		System.out.print("�̸� �Է� >> ");
		String name=in.readLine();
		System.out.println("==============================================================");
		//STUDENT ���̺� ����� �л����� �� �Է� �̸��� ���� �̸��� �л������� �˻��Ͽ� ���
		Connection con=ConnectionFactory.getConnection();
		
		//InParameter�� Java �������� ������ SQL ����� �����θ� ó��
		String sql="select * from student where name=? order by no";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<�˻���� ���>>");
		if(rs.next()) {
			do {
				System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
			} while(rs.next());
		} else {
			System.out.println("�˻��� �л������� �����ϴ�.");
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("==============================================================");
		
	}
}