package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnect {
	//서버가 시작될때 딱 한번만 생성하고 서버끝나면 종료
	private static Connection conn=null;
	
	//메서드 가 실행해야 Connection 객체가 생성이된다.
	public static Connection getInstance() {
		if(conn!=null)new DBConnect();
		return conn;
	}
	
	//Connection 객체 초기화
	private DBConnect() {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

}