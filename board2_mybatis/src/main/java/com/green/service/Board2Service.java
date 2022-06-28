package com.green.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Board2Service {
	//추상 메서드
	void findAll(HttpServletRequest request, HttpServletResponse response);

	void insert(HttpServletRequest request, HttpServletResponse response);

	void detail(HttpServletRequest request, HttpServletResponse response);

	void delete(HttpServletRequest request, HttpServletResponse response);

	void update(HttpServletRequest request, HttpServletResponse response);

	void findBoardByPage(HttpServletRequest request, HttpServletResponse response);

	
}