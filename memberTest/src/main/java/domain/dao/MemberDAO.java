package domain.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.dto.LoginOK;
import domain.dto.LoginRequestDto;
import domain.dto.MemberDTO;
import domain.dto.MemberDetailDTO;
import domain.dto.MemberUpdateDTO;
import mybatis.MybatisConfig;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory=MybatisConfig.getInstance();

	public void insert(MemberDTO dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		//member-mapper.xml 에 쿼리요청
		sqlSession.insert("memberMapper.insert", dto);
		
		sqlSession.close();
	}

	public LoginOK logCheck(LoginRequestDto dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//member-mapper.xml 에 쿼리요청
		LoginOK result=sqlSession.selectOne("memberMapper.logCheck", dto);
		
		sqlSession.close();
		return result;
	}

	public MemberDetailDTO findById(String id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//member-mapper.xml 에 쿼리요청
		MemberDetailDTO result=sqlSession.selectOne("memberMapper.findById", id);
		
		sqlSession.close();
		return result;
	}

	public void update(MemberUpdateDTO dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		//member-mapper.xml 에 쿼리요청
		sqlSession.update("memberMapper.update", dto);
		
		sqlSession.close();
		
	}

	public void delete(String id) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		//member-mapper.xml 에 쿼리요청
		sqlSession.update("memberMapper.delete", id);
		
		sqlSession.close();
	}

}