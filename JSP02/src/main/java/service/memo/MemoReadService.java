package service.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.dto.memo.MemoDTO;
import mybatis.MybatisManager;

public class MemoReadService implements MemoService {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//메모테이블의 모든데이터를 읽어들이는 서비스
		
		//1. DB에 접근해서 메모데이터 읽어오기
		SqlSessionFactory sqlSessionFactory=MybatisManager.getInstance();

		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<MemoDTO> result=sqlSession.selectList("memoMapper.findAll");
		sqlSession.close();
		
		//2. 읽어온데이터 페이지에 표현하기위해 전송
		request.setAttribute("list", result);
		
	}

}