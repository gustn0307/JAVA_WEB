package com.green.domain.dto;

import java.time.LocalDateTime;


public class Board2DTO {

	/*
	 * ////////////////////////////////////////////////
	 * 멤버 필드//////////////////////////
	 */
	
	private int no;
	private String subject;
	private String content;
	private int read_count;
	private String writer;
	private LocalDateTime created_date;

	/*
	 * ////////////////////////////////////////////////
	 * 멤버 메서드//////////////////////////
	 */
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	/*
	 * ////////////////////////////////////////////////
	 * 생성자//////////////////////////
	 */	
	public Board2DTO() {
		// TODO Auto-generated constructor stub
	}
	public Board2DTO(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	public Board2DTO(int no, String subject, String content) {
		this.no = no;
		this.subject = subject;
		this.content = content;
	}
	
	
}