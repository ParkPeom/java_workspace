package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Statement �ν��Ͻ��� ��ȯ�ϴ� �޼��忡 ���޵Ǵ� ���� ���� ResultSet �ν��Ͻ��� ��� ��� ����
// => ResultSet Ŀ���� ��ġ ���� �Ǵ� ResultSet Ŀ�� ��ġ�� ����� , �÷��� ���� , �� ���� ,  �� ���� ���� ������ ����
public class ResultSetCursorApp {

	public static void main(String[] args) throws SQLException {
	Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : Statement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Statement : SQL ����� ���ӵ� DBMS ������ �����ϱ� ���� �ν��Ͻ�
		// => executeQuery() �޼ҵ� �Ǵ� executeUpdate() �޼ҵ带 ȣ���Ͽ� SQL ��� ����
		//Statement.executeQuery(String sql) : SELECT ����� �����Ͽ� �����ϰ� �˻������
		//ResultSet �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => ResultSet �ν��Ͻ��� Ŀ���� �̿��Ͽ� ������� ó��
		// => ResultSet Ŀ���� ���������� �̵��� �����ϸ� Ŀ�� ��ġ�� �࿡ ���� ���� �Ұ���
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ�
		// => Ŀ�� ��ġ�� ó������ ���� ��� false ��ȯ�ϸ� ó������ �ִ� ��� true ��ȯ
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet Ŀ���� ��ġ�� ó������ ���ȣ(RowIndex)�� ��ȯ�ϴ� �޼ҵ�
			//ResultSet.getXXX(String columnLabel) : ResultSet Ŀ���� ��ġ�� ó������ �÷����� ��ȯ�ϴ� �޼ҵ�
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
		con=ConnectionFactory.getConnection();
		
		//Connection.createStatement(int resultSetType, int resultSetConcurrency)
		// => Statement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => �Ű������� ���޵Ǵ� ���� ���� SELECT ����� �������� ������ ResultSet �ν��Ͻ��� �Ӽ� ����
		//resultSetType : ResultSet Ŀ���� �̵� ���� �Ӽ� - ������ ��� ��� ���
		// => ResultSet.TYPE_FORWARD_ONLY : ResultSet Ŀ���� ���������θ� �̵�(�⺻)
		// => ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet Ŀ���� ���ϴ� ������ �̵� - ������ �̹ݿ� 
		// => ResultSet.TYPE_SCROLL_SENSITIVE : ResultSet Ŀ���� ���ϴ� ������ �̵� - ������ �ݿ�
		//resultSetConcurrency : ResultSet Ŀ�� ��ġ�� �࿡ ���� ���� ���� �Ӽ� - ������ ��� ��� ���
		// => ResultSet.CONCUR_READ_ONLY : ResultSet Ŀ�� ��ġ�� �࿡ ���� ���� �Ұ���
		// => ResultSet.CONCUR_UPDATABLE : ResultSet Ŀ�� ��ġ�� �࿡ ���� ���� ����
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		sql="select * from student order by no";
		rs=stmt.executeQuery(sql);
		
		//ResultSet.first() : ResultSet Ŀ���� ù��° �˻������� �̵��ϴ� �޼ҵ� 
		rs.first();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));

		//ResultSet.last() : ResultSet Ŀ���� ������ �˻������� �̵��ϴ� �޼ҵ� 
		rs.last();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		//ResultSet.absolute(int rowIndex) : ResultSet Ŀ���� ���ϴ� ��ġ�� �˻������� �̵��ϴ� �޼ҵ� 
		rs.absolute(2);
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		System.out.println("==============================================================");
		//ResultSet.beforeFirst() : ResultSet Ŀ���� BOF �������� �̵��ϴ� �޼ҵ� 
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		//ResultSet.afterLast() : ResultSet Ŀ���� EOF �������� �̵��ϴ� �޼ҵ� 
		rs.afterLast();
		//ResultSet.previous() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ�
		while(rs.previous()) {
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
		con=ConnectionFactory.getConnection();

		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		//ResultSet Ŀ�� ��ġ�� ���� �����ϰ��� �� ��� SELECT ��ɿ��� �˻�������� * ��� �Ұ���
		sql="select no,name,phone,address,birthday from student order by no";
		rs=stmt.executeQuery(sql);
		
		/*
		//3��° �࿡ ���ο� ���� ���̺� �����Ͽ� �����ϴ� ��� - INSERT 
		rs.absolute(2);
		
		//ResultSet.moveToInsertRow() : ResultSet Ŀ�� ��ġ �Ʒ��� ���ο� ���� �����ϴ� �޼ҵ�
		// => �������� ���������� �ڵ� �̵�
		rs.moveToInsertRow();
		
		//���Ե� �࿡ �÷��� ����
		//ResultSet.updateXXX(String columnLabel, XXX value) :  ResultSet Ŀ�� ��ġ�� �࿡
		//�÷����� �����ϴ� �޼ҵ� - XXX : Java �ڷ���
		rs.updateInt("no", 5000);
		rs.updateString("name", "����");
		rs.updateString("phone", "010-7894-3241");
		rs.updateString("address", "�λ�� ���ϱ�");
		//rs.updateDate("birthday", new Date(100, 11, 20));//2000-12-20
		rs.updateString("birthday", "2000-12-20");
		
		//ResultSet.insertRow() : ResultSet ��ġ�� ó������ ���̺� �����ϴ� �޼ҵ�
		rs.insertRow();
		*/
		
		/*
		//������ ���� ���̺� �����ϴ� ��� - DELETE
		rs.last();

		//ResultSet.deleteRow() : ResultSet ��ġ�� ó������ ���̺��� �����ϴ� �޼ҵ�
		rs.deleteRow();
		*/
		
		//2��° ���� name �÷����� �����ϰ� ���̺��� �����ϴ� ��� - UPDATE 
		rs.absolute(2);
		
		rs.updateString("name", "�Ӳ���");
		
		//ResultSet.updateRow() : ResultSet ��ġ�� ó������ ���̺��� �����ϴ� �޼ҵ�
		rs.updateRow();
		
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
	}
}


