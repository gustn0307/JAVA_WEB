package com.green.domain.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.green.domain.dto.Board2DTO;
import com.green.mybatis.MybatisConfig;

public class Board2DAO {
	
	private SqlSessionFactory sqlSessionFactory=MybatisConfig.getInstance();

	public List<Board2DTO> findAll() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//매퍼실행
		List<Board2DTO> result=sqlSession.selectList("board2Mapper.findAll");
		
		sqlSession.close();
		return result;
	}

	//DB에 저장
	public int insert(Board2DTO dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		//매퍼
		int result=sqlSession.insert("board2Mapper.save", dto);
		//insert처리한 레코드 수를 리턴
		sqlSession.close();
		return result;
	}

	public Board2DTO detail(int no) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//조회수 1업
		int ea=sqlSession.update("board2Mapper.up", no);
		
		Board2DTO result=sqlSession.selectOne("board2Mapper.detail", no);
		
		if(ea>0 && result==null) {
			sqlSession.rollback();
			return null;
		}
		sqlSession.commit();
		sqlSession.close();
		//트랜잭션
		return result;
	}

	//삭제처리
	public int delete(int no) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		//삭제된 개수
		int result=sqlSession.delete("board2Mapper.del", no);
		
		sqlSession.close();
		return result;
	}

	//수정처리
	public int update(Board2DTO dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int result=sqlSession.update("board2Mapper.update", dto);
		sqlSession.close();
		return result;
	}

	public List<Board2DTO> findBoardByPage(RowBounds rb) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Board2DTO> result=sqlSession.selectList("board2Mapper.findAll", null, rb);
		sqlSession.close();
		return result;
	}

	

}