package domain.dto;

import java.sql.Timestamp;

public class MemberDTO {
	
	private int no;
	private String email;
	private String pass;
	private String nick_name;
	private Timestamp created_date;
	//*
	public int getNo() {
		return no;
	}
	//*/
	//*
	public void setNo(int no) {
		this.no = no;
	}
	//*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", email=" + email + ", pass=" + pass + ", nick_name=" + nick_name
				+ ", created_date=" + created_date + "]";
	}
	//생성자
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	//생성자
	public MemberDTO(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	
	

}