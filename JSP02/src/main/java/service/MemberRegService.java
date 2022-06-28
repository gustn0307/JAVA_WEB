package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.dto.MemberDTO;

public class MemberRegService implements MemberService {
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		/*
		MemberDTO dto=new MemberDTO();
		dto.setEmail(email);
		dto.setPass(pass);
		*/
		MemberDTO dto=new MemberDTO(email, pass);
		
		
		//회원가입해주세요.
		SqlSession sqlSession=sqlSessionFactory.openSession(true);//auto commit
		
		int ea=sqlSession.insert("memberMapper.reg", dto);
		sqlSession.close();
		System.out.println(ea+ " 명 회원가입!");
		if(ea==1) {
			request.setAttribute("logMsg", "회원가입을 축하합니다.");
		}
		
		
		String path="/WEB-INF/view/signin.jsp";//페이지 이동할 주소
		return path;
		
	}
	
	

}