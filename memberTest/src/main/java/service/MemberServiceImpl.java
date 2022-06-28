package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.dao.MemberDAO;
import domain.dto.LoginOK;
import domain.dto.LoginRequestDto;
import domain.dto.MemberDTO;
import domain.dto.MemberDetailDTO;
import domain.dto.MemberUpdateDTO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO dao=new MemberDAO();

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String addr=request.getParameter("addr");
		String gender=request.getParameter("gender");// M|F|X
			String year=request.getParameter("year").trim();
			String month=request.getParameter("month").trim();
			String day=request.getParameter("day").trim();
		String birth="none";
			if(year !="" && month !="" && day!="") birth=year+month+day;
		System.out.println("birth : "+birth);
		
		String add_item=request.getParameter("add_item");// recommend|event
		if(add_item==null) add_item="none";
		
		String agree=request.getParameter("agree");//필수
		String private1=request.getParameter("private1");//필수
		String fourteen_chk=request.getParameter("fourteen_chk");//필수
		
		String private2=request.getParameter("private2");//선택
		if(private2==null)private2="f";
		
		String marketing=request.getParameter("marketing");//선택
		if(marketing==null)marketing="f";
		
		String sms=request.getParameter("sms");//선택
		if(sms==null)sms="f";
		
		String mailling=request.getParameter("mailling");//선택\
		if(mailling==null)mailling="f";
		/*
		MemberDTO dto=new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setAddr(addr);
		dto.setGender(gender);
		dto.setBirth(birth);
		dto.setAdd_item(add_item);
		dto.setAgree(agree);
		dto.setPrivate1(private1);
		dto.setPrivate2(private2);
		dto.setFourteen_chk(fourteen_chk);
		dto.setMarketing(marketing);
		dto.setSms(sms);
		dto.setMailling(mailling);
		*/
		
		MemberDTO dto=new MemberDTO(id, pw, name, email, addr, phone, gender, birth, add_item, agree, private1, private2, marketing, sms, mailling, fourteen_chk);
		
		dao.insert(dto);
		
		response.sendRedirect("login");
		
	}

	@Override
	public String logCheck(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		LoginRequestDto dto=new LoginRequestDto();
		dto.setPw(pw);
		dto.setId(id);
		
		//로그인 성공시 LoginOK 정보저장
		//로그인 실패시 null
		LoginOK result=dao.logCheck(dto);
		//System.out.println("result : "+result);
		if(result == null){
			//로그인 실패
			//실패시 메세지
			String msg="아이디나 패스워드가 일치 하지 않습니다!";
			request.setAttribute("msg", msg);
			//페이지 이동정보
			return "/WEB-INF/view/login.jsp";
		}else {
			//로그인 성공시
			//request.setAttribute("userInfo", result);
			//Scope: page < request < session < application
			//ServletContext application=request.getServletContext();
			HttpSession session=request.getSession();
			//session.setMaxInactiveInterval(60);//초단위 설정
			session.setAttribute("userInfo", result);
			//1. 브라우저가 유지되는 동안 정보유지
			//2. 설정한 시간까지 유지
			
			//*
			  try { 
				  response.sendRedirect(request.getContextPath()+"/"); //index.jsp가응답 }
			  }
			  catch (IOException e) { e.printStackTrace(); }
			//*/ 
			return null;
		}
		
	}//logCheck

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("userInfo");
		//*
		  try { 
			  response.sendRedirect(request.getContextPath()+"/"); 
		  }
		  catch (IOException e) { e.printStackTrace(); }
		//*/ 
	}//logout

	@Override
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		//String sname=request.getParameter("sname");
		
		HttpSession session=request.getSession();
		LoginOK userInfo=(LoginOK) session.getAttribute("userInfo");
		
		//System.out.println(userInfo.getId());
		MemberDetailDTO result=dao.findById( userInfo.getId() );
		System.out.println("result : "+result);
		//페이지에 데이터 전달하기 위해
		
		request.setAttribute("detail", result);
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newPw=request.getParameter("newPw");
		LoginOK userInfo =(LoginOK) request.getSession().getAttribute("userInfo");
		String id=userInfo.getId();
		
		MemberUpdateDTO dto=new MemberUpdateDTO();
		dto.setId(id);
		dto.setPw(newPw);
		
		dao.update(dto);
		request.setAttribute("changedPw", "비밀번호 변경이 완료되었습니다.");
		//데이터 갖고오기
		MemberDetailDTO result=dao.findById( userInfo.getId() );
		request.setAttribute("detail", result);
		//response.sendRedirect("detail");
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginOK userInfo =(LoginOK) request.getSession().getAttribute("userInfo");
		String id=userInfo.getId();
		
		dao.delete(id);
		response.sendRedirect("logout");
		
	}

	

}//class