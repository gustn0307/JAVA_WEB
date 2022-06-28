package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.dto.MemberDTO;

public class MemberCheckService implements MemberService{
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//System.out.println(sqlSessionFactory);
		String email=request.getParameter("email");
		
		//DB 처리부분
		SqlSession sqlSession=sqlSessionFactory.openSession();//true : auto commit
		//mapper에서 쿼리실행
		//                   namespace.id
		MemberDTO dto=sqlSession.selectOne("memberMapper.emailCheck", email);
		//sqlSession.commit(); or auto commit 적용
		sqlSession.close();
		
		PrintWriter out= response.getWriter();
		if(dto==null) {//해당이메일은 현재 DB에 존재하지 않아서 null
			out.print(false);
		}else {
			out.print(true);
		}
		
		
		return null;
	}

}