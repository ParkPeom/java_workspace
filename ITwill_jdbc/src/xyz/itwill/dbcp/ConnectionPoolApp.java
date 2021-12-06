package xyz.itwill.dbcp;


import java.sql.Connection;
import java.sql.SQLException;

//DBCP (DataBase ConnectionPool) : Connection 인스턴스를 미리 여러 개 생성하여 저장하고 
//COnnection 인스턴스를 반환하는 기능을 제공하는 클래스 
// = > Connection 인스턴스의 접속정보에 대한 변경이 용이하다 
// = > Connection 인스턴스를 미리 만들어 사용하므로 JDBC 프로그램의 실행 속도가 증가 
// = > Connection 인스턴스의 갯수 제한 가능 
public class ConnectionPoolApp {

	public static void main(String[] args) throws SQLException {
		//ConnectionPool 인스턴스를 반환받아 저장
				// => 싱글톤 디자인 패턴이 적용된 클래스이므로 프로그램에 인스턴스를 하나만 제공한다.
				// => ConnectiomPool 인스턴스에 Connection 인스턴스를 콜렉션 필드에 미리 여러개 생성하여 저장 해놓고
				ConnectionPool cp = ConnectionPool.getInstance();
				
				//connectionpool 인스턴스의 콜렉션 필드에 저장된 connection 인스턴스에 하나만 반환받아 저장
				Connection con1 = cp.getConnection();
				System.out.println("con1 = "+con1);
				//사용한 Connection 인스턴스를 ConnectionPool 인스턴스에 되돌려주어 콜렉션 필드에 저장할수 있도록 만든다.
				cp.freeConnection(con1); //  >> 자전거를 가지고 안돌려주고 감 
					//반납
				Connection con2 = cp.getConnection();
				System.out.println("con2 = "+con2);
				//사용한 Connection 인스턴스를 ConnectionPool 인스턴스에 되돌려주어 콜렉션 필드에 저장할수 있도록 만든다.
				cp.freeConnection(con2); //  >>자전거 또가져감 ㅋㅋ
				
				Connection con3 = cp.getConnection();
				System.out.println("con3 = "+con3);
				//사용한 Connection 인스턴스를 ConnectionPool 인스턴스에 되돌려주어 콜렉션 필드에 저장할수 있도록 만든다.
				cp.freeConnection(con3); 
				
				Connection con4 = cp.getConnection();
				System.out.println("con4 = "+con4);
				//사용한 Connection 인스턴스를 ConnectionPool 인스턴스에 되돌려주어 콜렉션 필드에 저장할수 있도록 만든다.
				cp.freeConnection(con4);
			}

		}
