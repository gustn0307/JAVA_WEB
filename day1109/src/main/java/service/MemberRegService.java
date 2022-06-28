package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnect;

public class MemberRegService implements MemberService {
	private Connection conn=DBConnect.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		System.out.println(email);
		System.out.println(pass);
		
		System.out.println(conn.hashCode());
		String sql="insert into member "
				+ "values(seq_mem.nextval, ?, ?, null, sysdate)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String msg=email+", 회원가입을 축하합니다.";
		
		request.setAttribute("logMsg", msg);
		
		String path="/WEB-INF/view/signin.jsp";//페이지 이동할 주소
		return path;
		
	}
	
	

}