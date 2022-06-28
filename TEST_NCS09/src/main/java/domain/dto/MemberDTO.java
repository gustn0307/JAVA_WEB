package domain.dto;

import java.sql.Timestamp;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String addr;
	private String gender;
	private String birth;
	private String add_item;
	private String agree;
	private String private1, private2;
	private String marketing;
	private String sms, mailing;
	private String fourteen_chk;
	private Timestamp created_date;

	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
	public String getAdd_item() {
		return add_item;
	}
	public void setAdd_item(String add_item) {
		this.add_item = add_item;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getPrivate1() {
		return private1;
	}
	public void setPrivate1(String private1) {
		this.private1 = private1;
	}
	public String getPrivate2() {
		return private2;
	}
	public void setPrivate2(String private2) {
		this.private2 = private2;
	}
	public String getMarketing() {
		return marketing;
	}
	public void setMarketing(String marketing) {
		this.marketing = marketing;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getMailing() {
		return mailing;
	}
	public void setMailing(String mailing) {
		this.mailing = mailing;
	}
	public String getFourteen_chk() {
		return fourteen_chk;
	}
	public void setFourteen_chk(String fourteen_chk) {
		this.fourteen_chk = fourteen_chk;
	}

	//생성자
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	//생성자
	public MemberDTO(String id, String pw, String name, String email, String phone, String addr, String gender, String birth, String add_item,
			String agree, String private1, String private2, String marketing, String sms, String mailing, String fourteen_chk) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.gender = gender;
		this.birth = birth;
		this.add_item=add_item;
		this.agree = agree;
		this.private1 = private1;
		this.private2 = private2;
		this.marketing = marketing;
		this.sms = sms;
		this.mailing = mailing;
		this.fourteen_chk = fourteen_chk;
	}
}