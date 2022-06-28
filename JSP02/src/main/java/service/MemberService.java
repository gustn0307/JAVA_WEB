package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisManager;

public interface MemberService {
	
	SqlSessionFactory sqlSessionFactory=MybatisManager.getInstance();
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}