package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/input")
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("등록버튼을 누르면 서버에 전달됩니다.");
		request.setCharacterEncoding("utf-8");
		// form 태그에서 넘어온 데이터 처리
		String goods = request.getParameter("goodsName");
		// 가격 정보도 숫자로 쓸 예정이지만 getParameter가 문자열로만 리턴되므로 일단 문자열로 받고 숫자로만 구성된 문자열은 숫자형으로
		// 변환가능하므로 나중에 숫자로 변환
		String _price = request.getParameter("price");
		int price = Integer.parseInt(_price);

		String sql = "insert into goods values(seq_no.nextval, ?, ?, sysdate)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods);
			pstmt.setInt(2, price);
			pstmt.executeUpdate();

			System.out.println("입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 처리했다는 결과 웹페이지로 보여주기(다시 인덱스로 돌아가기)
		String path = request.getContextPath() + "/";
		response.sendRedirect(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post로 전달되었습니다.");

		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		// 서블릿이 최초 실행될때만 한번만 실행되는 메소드
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			this.conn = ds.getConnection();
			System.out.println("DBCP 완료");

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
