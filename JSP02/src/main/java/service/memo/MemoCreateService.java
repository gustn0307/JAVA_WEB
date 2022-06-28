package service.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.dto.memo.MemoCreateDTO;
import domain.dto.memo.MemoDTO;
import mybatis.MybatisManager;

public class MemoCreateService implements MemoService {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//메모쓰기 기능처리
		//웹에서 등록한 writer, content정보 DB에 넣어라.
		//1. 입력정보 확보
		request.setCharacterEncoding("utf-8");//한글처리를 위한 인코딩설정
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		//MemoCreateDTO dto=new MemoCreateDTO();
		//dto.setWriter(writer);
		//dto.setContent(content);
		MemoCreateDTO dto=new MemoCreateDTO(writer, content);
		
		System.out.println("wirter : "+writer);
		System.out.println("content : "+content);
		//2. 정보를DB에 넣어라
		SqlSessionFactory sqlSessionFactory=MybatisManager.getInstance();
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		//sqlSession.insert("mapperNamespace.id", 입력할데이터);
		
		sqlSession.insert("memoMapper.create", dto);
		//List<MemoDTO> result=sqlSession.selectList("memoMapper.findAll");
		//request.setAttribute("list", result);
		
		sqlSession.close();

	}

}