package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.memo.MemoCreateService;
import service.memo.MemoDeleteService;
import service.memo.MemoDetailService;
import service.memo.MemoReadService;
import service.memo.MemoService;



@WebServlet("/memo/*")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		System.out.println("uri : "+ uri);
		//    /day1109/memo/list
		String[] strs=uri.split("[/]");
		//{"","day1109","memo","list"}
		// 0 ,    1    ,  2   ,  3   
		//length == 4
		String key=strs[strs.length-1]; //strs배열의 마지막 인덱스번호
		
		//CRUD
		MemoService service=null;
		
		String path=null;
		if(key.equals("list")) {
			//페이지로 이동전에 데이터를 읽어오는기능
			service=new MemoReadService();
			//service.process(request, response);
			path="/WEB-INF/view/memo/memo-list.jsp";
			//페이지정보를 서비스에서 결정하지 않고 controller에서 결정할떄..
		}else if(key.equals("memo-write")) {
			path="/WEB-INF/view/memo/memo-write.jsp";//페이지이동하기 위한 정보
		}else if(key.equals("memo-reg")) {
			//글쓰기처리기능 실행
			service=new MemoCreateService();
			//service.process(request, response);
			//페이지 이동
			//path="/WEB-INF/view/memo/memo-write.jsp";//페이지이동하기 위한 정보
			//path="/WEB-INF/view/memo/memo-list.jsp";//체크해봐야할 대상입니다.
			//리스트 페이지를 요청: url주소 변경 list
			response.sendRedirect("list");//서버로 재요청("list")@@@
		}else if(key.equals("detail")) {
			//상세정보 확인
			service=new MemoDetailService();
			path="/WEB-INF/view/memo/memo-detail.jsp";
		}else if(key.equals("delete")) {
			//삭제기능
			service=new MemoDeleteService();
			//리스트갖고오는 서비스를 실행
			response.sendRedirect("list");
		}
		
		//서비스 실행
		if(service!=null)//service가 null이 아닐때만 실행
			service.process(request, response);
		
		//페이지이동
		if(path!=null) {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}