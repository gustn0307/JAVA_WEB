package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnect;


@WebServlet(urlPatterns = {"/home","/member","/member-reg","/login","/email-check"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		conn=(Connection) config.getServletContext().getAttribute("oracleDB");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//인코딩
		response.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		StringBuffer _url=request.getRequestURL();
		String url=new String(_url);
		System.out.println("URI : "+ uri);// /day1109/member
		//System.out.println("URL : "+ url);// Request URL: http://localhost:8080/day1109/member
		String[] strs=url.split("/");
		//{"","day1109","member"}
		String key=strs[strs.length-1];
		
		
		String path=null;
		if(key.equals("member")) {
			
			path="/WEB-INF/view/signup.jsp";
		}else if(key.equals("home")) {
			path="index.jsp";
		}else if(key.equals("login")) {
			path="/WEB-INF/view/signin.jsp";
		}else if(key.equals("member-reg")) {
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
			
			path="/WEB-INF/view/signin.jsp";
			
		}else if(key.equals("email-check")) {
			String input_email=request.getParameter("email");		
			System.out.println("input_email : "+input_email);			
			String sql="select * from member where email=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, input_email);
				
				ResultSet rs=pstmt.executeQuery();//이메일이 존재하는지 여부확인하기위한 쿼리실행
				
				boolean result=rs.next();
				
				response.getWriter().print(result);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return;
		}
		
		
		//페이지 이동
		if(path!=null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}