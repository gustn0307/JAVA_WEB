package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.service.Board2Service;
import com.green.service.board2.Board2ServiceImpl;

//어노테이션이 적용이 않되어있는경우 web.xml에 서블릿을 등록 url매핑처리
//@WebServlet("/board2/*")
public class Board2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Board2Service service=new Board2ServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* /board2/*   */
		request.setCharacterEncoding("utf-8");//한글처리하기위한 인코딩
		String uri=request.getRequestURI();
		String[] strs=uri.split("/");
		String key=strs[strs.length-1];
		
		String path=null;
		
		if(key.equals("list")) {
			//service.findAll(request, response);//DB에서 게시글list정보를 읽어오는 기능
			
			service.findBoardByPage(request, response);
			
			path="/WEB-INF/view/board2/list.jsp";// webapp 부터 path경로 설정
		}else if(key.equals("write")) {
			path="/WEB-INF/view/board2/write.jsp";
		}else if(key.equals("insert")) {
			//formData를 DB에 넣어라
			service.insert(request, response);
			//페이지 이동은?
			response.sendRedirect("list");
		}else if(key.equals("detail")) {
			//db에서 요청하는no의 상세페이지 정보갖고 와야한다.
			service.detail(request, response);			
			//페이지 이동
			path="/WEB-INF/view/board2/detail.jsp";
		}else if(key.equals("delete")) {
			
			service.delete(request, response);
			response.sendRedirect("list");
		}else if(key.equals("update")) {
			service.update(request, response);
			response.sendRedirect("detail?no="+request.getParameter("no"));
		}
		
		//페이지 이동
		if(path!=null) 
			request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}