package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.dto.MemberDTO;

public class MemberListService implements MemberService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		//DML : DQL(select)
		
		//mapper이용해서 조회
		List<MemberDTO> result=sqlSession.selectList("memberMapper.memberList");
		
		//웹페이지에서 result정보를 확인하기위해서
		request.setAttribute("list", result);
		
		sqlSession.close();
		
		return "/WEB-INF/view/member-list.jsp";
	}

}