package com.green.service.board2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;

import com.green.domain.dao.Board2DAO;
import com.green.domain.dto.Board2DTO;
import com.green.service.Board2Service;

public class Board2ServiceImpl implements Board2Service {
	
	private Board2DAO dao=new Board2DAO();
	
	@Override
	public void findAll(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 게시글list정보를 읽어오는 기능
		//웹에서 넘어온정보는 없어요
		//DB에서 데이터 읽어오기
		List<Board2DTO> result=dao.findAll();
		
		
		
		//페이지로 이동할때 list데이터를 jsp페이지로 갖고 간다.
		request.setAttribute("list", result);
		request.setAttribute("today", LocalDate.now());
		
		LocalDateTime ldt=LocalDateTime.now();
		
		LocalDate date=ldt.toLocalDate();
		LocalTime time=ldt.toLocalTime();
		DateTimeFormatter format ;
		
	}

	@Override
	public void findBoardByPage(HttpServletRequest request, HttpServletResponse response) {
		
		String _page=request.getParameter("page");
		int page=1;//파라미터가 존재하지 않을경우 기본값으로 1
		
		if(_page!=null) {
			page= Integer.parseInt(_page);//파라미터가 존재하면 파라미터값으로 셋팅!
		}
		System.out.println("page: " +page);
		
		int limit=10;              //한페이지에 보여질 게시글 수
		int offset=limit*(page-1); //나온결과의 첫번째부터 건너뛸 개수 
		RowBounds rb=new RowBounds(offset, limit);
		List<Board2DTO> result=dao.findBoardByPage(rb);
		
		//페이지로 이동할때 list데이터를 jsp페이지로 갖고 간다.
		request.setAttribute("list", result);
		request.setAttribute("today", LocalDate.now());
		
	}

	//글쓰기
	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		//formData확인작업
		String writer=request.getParameter("writer").trim();
		String subject=request.getParameter("subject").trim();
		String content=request.getParameter("content").trim();
		//Board2DTO dto=new Board2DTO();//필드에 
		//dto.setWriter(writer);
		//dto.setContent(content);
		//dto.setSubject(subject);
		//for(int i=1; i<=100; i++) {
			Board2DTO dto=new Board2DTO(subject, content, writer);
			//formData DB에 저장
			int result=dao.insert(dto);
		//}
		System.out.println("insert결과 : "+result +"개 입력처리!");
		
	}
	
	//상세정보
	@Override
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		//query String parameter
		String _no=request.getParameter("no");
		int no=Integer.parseInt(_no);
		
		//DB작업\
			
		//detail갖고오기
		Board2DTO result=dao.detail(no);
		request.setAttribute("detail", result);
	}

	//삭제처리 
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String _no=request.getParameter("no");
		int no=Integer.parseInt(_no);
		
		int result=dao.delete(no);
		System.out.println("삭제결과 : "+no+"게시글 "+ result +"개의 데이터 삭제완료!");
		
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		String _no=request.getParameter("no");
		int no=Integer.parseInt(_no);
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		Board2DTO dto=new Board2DTO(no, subject, content);
		int result=dao.update(dto);
		
		System.out.println("수정결과 : "+no+"게시글 "+ result +"개의 데이터 수정완료!");
		//response.sendRedirect("detail?no="+no);
	}
	
	

}