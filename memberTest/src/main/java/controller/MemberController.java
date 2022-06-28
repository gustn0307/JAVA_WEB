package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service=new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] strs=request.getRequestURI().split("/");
		String key=strs[strs.length-1];
		System.out.println("key : "+key);
		
		String path=null;
		if(key.equals("page")) {
			path="/WEB-INF/view/member.jsp";
		}else if(key.equals("login")) {
			path="/WEB-INF/view/login.jsp";
		}else if(key.equals("member-reg")) {
			service.insert(request, response);
		}else if(key.equals("log-pro")) {
			//정상적으로 로그인이된경우 index
			//로그인 실패시 로그인페이지로 , 실패메세지
			path=service.logCheck(request, response);
			//path="/WEB-INF/view/login.jsp";
			//path=null;
		}else if(key.equals("logout")) {
			service.logout(request, response);
		}else if(key.equals("detail")) {
			service.detail(request, response);
			path="/WEB-INF/view/detail.jsp";
		}else if(key.equals("update")) {
			service.update(request, response);
			
			path="/WEB-INF/view/detail.jsp";
		}else if(key.equals("delete")) {
			service.delete(request, response);
		}
		
		//페이지이동
		if(path!=null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}