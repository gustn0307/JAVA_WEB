package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {

	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	String logCheck(HttpServletRequest request, HttpServletResponse response);

	void logout(HttpServletRequest request, HttpServletResponse response);

	void detail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

	void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

	void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

}