package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;

/* DB 연결 정보를 xml 파일에 별도로 작성해서 읽어오는 형식의 코드를 작성
 * -> DB 연결 정보는 변경될 가능성이 있는데
 * 	  그때 마다 컴파일 하는 것은 시간 낭비가 심하다
 *    --> 파일에 작성된 내용을 읽어오는 고정된 코드를 작성하고
 *        외부 파일의 내용을 변경하는 형식으로 코드를 작성
 *        
 * XML : 프로그래밍 언어 종류 상관 없이 데이터를 저장, 전달 가능한 파일
 * 
 * XML에 작성된 DB 연결 정보를 Properties 라는 객체를 이용해 얻어올 예정
 * 
 * Properties : 컬렉션 중 Map<K,V>의 후손 클래스로
 *              K, V가 모두 String으로 제한된 Map
 * 장점 : 파일 입출력에 특화 되어 있음 (특히 XML)
 * 
 * 
 * 
 * */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			
			if( conn == null || conn.isClosed() ) {
				
				// 외부 xml파일(driver.xml) 내용을 읽어와 저장할 Properties 객체 생성
				Properties prop = new Properties();
				
				// driver.xml 파일을 읽어와 저장
				prop.loadFromXML(new FileInputStream("driver.xml"));
				
				
				Class.forName(prop.getProperty("driver"));
				String url = prop.getProperty("url");
				String userName = prop.getProperty("userName");
				String password = prop.getProperty("password");
				
				conn = DriverManager.getConnection(url, userName, password);
				
				conn.setAutoCommit(false);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return conn;
	}
	
	
	public static void close(Statement stmt) {
		
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static void close(ResultSet rs) {

		try {
			if(rs != null && !rs.isClosed()) {
			rs.close();
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	public static void close(Connection conn) {

		try {
			if(conn != null && !conn.isClosed()) {
			conn.close();
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	
	public static void commit(Connection conn) {

		try {
			if(conn != null && !conn.isClosed()) {
			conn.commit();
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	public static void rollback(Connection conn) {

		try {
			if(conn != null && !conn.isClosed()) {
			conn.rollback();
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
