package com.none.jdbc.mysql.util;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库的打开与关闭类
 * @author Nathon
 *
 */
public class DBUtil {
	private static String DefaultConfPath = DBUtil.class.getClassLoader().getResource("config.properties").getPath();
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	static {
		Properties prop = new Properties();
		try {
			Reader in = new FileReader(DefaultConfPath);
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	
	/**
	 * 数据库打开
	 * @return
	 */
	public static Connection open(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 数据库关闭
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}