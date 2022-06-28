package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnect;

public class MemberCheckService implements MemberService{
	
	private Connection conn=DBConnect.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String input_email=request.getParameter("email");		
		System.out.println("input_email : "+input_email);			
		String sql="select * from member where email=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, input_email);
			
			ResultSet rs=pstmt.executeQuery();//이메일이 존재하는지 여부확인하기위한 쿼리실행
			
			boolean result=rs.next();
			response.getWriter().print(result);
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}