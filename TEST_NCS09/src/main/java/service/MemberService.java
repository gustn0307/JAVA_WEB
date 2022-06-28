package service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	
	//추상 메서드
	void insert(HttpServletRequest request, HttpServletResponse response);
}