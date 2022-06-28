package service.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisManager;

public class MemoDeleteService implements MemoService {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.삭제할 대상 no
		String _no=request.getParameter("no");
		int no=Integer.parseInt(_no);
		
		SqlSessionFactory sqlSessionFactory=MybatisManager.getInstance();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.delete("memoMapper.delete", no);
		sqlSession.close();
		

	}

}