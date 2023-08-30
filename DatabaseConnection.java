package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	//DB 접속
	//DB Driver, DB Url, user, password
	// com.mysql.cj.jdbc.Driver
	// jdbc:mysql://localhost:3306/DB명
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/productdb";
	
	//생성자를 private 생성
	private DatabaseConnection() {
		//DB연결시 반드시 try~catch를 사용해야 함.
		try {
			Class.forName(jdbcDriver); //드라이버를 로드하기위해 사용되는 메서드
			conn = DriverManager.getConnection(jdbcUrl, "mysqluser", "mysql"); // 드라이버에서 Url을 연결하기 위한 메서드 (Url, user, password 필요)
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}	
	}
	
	public static DatabaseConnection getInstance() {
		// 계속 돌려쓰기
		return dbc;

	}
	
	public Connection getConnection() {
		// 계속 돌려쓰기
		return conn;
	}

}
