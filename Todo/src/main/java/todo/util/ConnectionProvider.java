package todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Service : DAO 메소드에 메개변수로 전달
public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		
		//connection 객체 구하기
		
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
		return DriverManager.getConnection(dbUrl, "root", "14919");
		
	}
	public static void main(String[] args) throws SQLException {
		System.out.println(ConnectionProvider.getConnection());;
	}
}
