package domain.dto;

import java.time.LocalDateTime;

public class MemberDetailDTO {
	private int no;//시퀀스
	private String id;
	private String pw;
	private String name;
	private String email;
	private String addr;
	private String phone;
	private String gender;
	private String birth;
	private LocalDateTime created_date;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	
	@Override
	public String toString() {
		return "MemberDetailDTO [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", addr=" + addr + ", phone=" + phone + ", gender=" + gender + ", birth=" + birth + ", created_date="
				+ created_date + "]";
	}
	
	
		
}