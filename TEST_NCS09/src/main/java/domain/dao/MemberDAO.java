package domain.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import domain.dto.MemberDTO;
import mybatis.MybatisConfig;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory=MybatisConfig.getInstance();

	//DB에 저장
	public void insert(MemberDTO dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.insert("memberMapper.insert", dto);
		
		sqlSession.close();
	}
}
