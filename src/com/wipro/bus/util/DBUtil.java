package com.wipro.bus.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
	public static Connection getDBConnection() {
		Connection con=null;
		try {
		Class.forName("oracle.jdbc.driver.oracleDriver");
	     con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.100.13:orcl","t17101","pass123");
	}catch (ClassNotFoundException e) {
		System.out.println(e);
	}catch (SQLException e) {
		System.out.println(e);
	}
	return con;

}
}
