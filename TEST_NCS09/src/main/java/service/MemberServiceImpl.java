package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.dao.MemberDAO;
import domain.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = new MemberDAO();

	// 삽입
	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		// formData확인작업
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String gender = request.getParameter("gender");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birth;
		String recommend = request.getParameter("recommend");
		String event = request.getParameter("event");
		String add_item;
		String agree = request.getParameter("agree");
		String private1 = request.getParameter("private1");
		String private2 = request.getParameter("private2");
		String marketing = request.getParameter("marketing");
		String sms = request.getParameter("sms");
		String mailing = request.getParameter("mailing");
		String fourteen_chk = request.getParameter("fourteen_chk");

		if(gender==null) {
			gender = "X";
		}
		
		if(year==null || month==null || day==null) {
			birth = "00000000";
		}else {		
			birth = year + month + day;
		}
		
		if(recommend==null || event==null) {
			add_item="none";
		}else {
			add_item=recommend+event;
		}
		
		if(agree!=null) {
			agree="T";
		}else {
			agree="F";
		}
		
		if(private1!=null) {
			private1="T";
		}else {
			private1="F";
		}
		
		if(private2!=null) {
			private2="T";
		} else {
			private2="F";
		}
		
		if(marketing!=null) {
			marketing="T";
		} else {
			marketing="F";
		}
		
		if(sms!=null) {
			sms="T";
		} else {
			sms="F";
		}
		if(mailing!=null) {
			mailing="T";
		} else {
			mailing="F";
		}
		if(fourteen_chk!=null) {
			fourteen_chk="T";
		}else {
			fourteen_chk="F";
		}
		MemberDTO dto = new MemberDTO(id, pw, name, email, phone, addr, gender, birth, add_item, agree,
				private1, private2, marketing, sms, mailing, fourteen_chk);
		// formData DB에 저장
		dao.insert(dto);
	}
}
