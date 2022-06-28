package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberCheckService;
import service.MemberRegService;
import service.MemberService;

@WebServlet(urlPatterns = {"/home","/member","/login"})
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri=request.getRequestURI();
		String[] strs=uri.split("/");
		String key=strs[strs.length-1];
		
		String path=null;
		if(key.equals("member")) {
			path="/WEB-INF/view/signup.jsp";
		}else if(key.equals("home")) {
			path="index.jsp";
		}else if(key.equals("login")) {
			path="/WEB-INF/view/signin.jsp";
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