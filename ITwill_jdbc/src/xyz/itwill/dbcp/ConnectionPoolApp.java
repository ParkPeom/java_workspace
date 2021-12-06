package xyz.itwill.dbcp;


import java.sql.Connection;
import java.sql.SQLException;

//DBCP (DataBase ConnectionPool) : Connection �ν��Ͻ��� �̸� ���� �� �����Ͽ� �����ϰ� 
//COnnection �ν��Ͻ��� ��ȯ�ϴ� ����� �����ϴ� Ŭ���� 
// = > Connection �ν��Ͻ��� ���������� ���� ������ �����ϴ� 
// = > Connection �ν��Ͻ��� �̸� ����� ����ϹǷ� JDBC ���α׷��� ���� �ӵ��� ���� 
// = > Connection �ν��Ͻ��� ���� ���� ���� 
public class ConnectionPoolApp {

	public static void main(String[] args) throws SQLException {
		//ConnectionPool �ν��Ͻ��� ��ȯ�޾� ����
				// => �̱��� ������ ������ ����� Ŭ�����̹Ƿ� ���α׷��� �ν��Ͻ��� �ϳ��� �����Ѵ�.
				// => ConnectiomPool �ν��Ͻ��� Connection �ν��Ͻ��� �ݷ��� �ʵ忡 �̸� ������ �����Ͽ� ���� �س���
				ConnectionPool cp = ConnectionPool.getInstance();
				
				//connectionpool �ν��Ͻ��� �ݷ��� �ʵ忡 ����� connection �ν��Ͻ��� �ϳ��� ��ȯ�޾� ����
				Connection con1 = cp.getConnection();
				System.out.println("con1 = "+con1);
				//����� Connection �ν��Ͻ��� ConnectionPool �ν��Ͻ��� �ǵ����־� �ݷ��� �ʵ忡 �����Ҽ� �ֵ��� �����.
				cp.freeConnection(con1); //  >> �����Ÿ� ������ �ȵ����ְ� �� 
					//�ݳ�
				Connection con2 = cp.getConnection();
				System.out.println("con2 = "+con2);
				//����� Connection �ν��Ͻ��� ConnectionPool �ν��Ͻ��� �ǵ����־� �ݷ��� �ʵ忡 �����Ҽ� �ֵ��� �����.
				cp.freeConnection(con2); //  >>������ �ǰ����� ����
				
				Connection con3 = cp.getConnection();
				System.out.println("con3 = "+con3);
				//����� Connection �ν��Ͻ��� ConnectionPool �ν��Ͻ��� �ǵ����־� �ݷ��� �ʵ忡 �����Ҽ� �ֵ��� �����.
				cp.freeConnection(con3); 
				
				Connection con4 = cp.getConnection();
				System.out.println("con4 = "+con4);
				//����� Connection �ν��Ͻ��� ConnectionPool �ν��Ͻ��� �ǵ����־� �ݷ��� �ʵ忡 �����Ҽ� �ֵ��� �����.
				cp.freeConnection(con4);
			}

		}
