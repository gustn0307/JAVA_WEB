package service.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.dto.memo.MemoDTO;
import mybatis.MybatisManager;

public class MemoDetailService implements MemoService {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _no=request.getParameter("no");
		//숫자로 만들어진 문자열은 숫자로 변환가능
		int no= Integer.parseInt(_no);
		
		//DB에서 no값에 해당하는 레코드(row)만 읽어오기
		SqlSessionFactory sqlSessionFactory=MybatisManager.getInstance();
		SqlSession sqlSession=sqlSessionFactory.openSession();
		MemoDTO dto=sqlSession.selectOne("memoMapper.detail", no);
		sqlSession.close();		
		request.setAttribute("detail", dto);

	}

}