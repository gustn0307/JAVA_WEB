<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="index.css">
	</head>
	<body>
		<main>
			<h1>메인영역</h1>
			<div class="wrap">
				<section id="form">
					<h1>회원가입폼</h1>
					<div class="wrap">
						<form action="member-reg" method="get" >
							<table>
								<thead>
									<tr>
										<th colspan="3">
											<span>회원가입</span>
										</th>
									</tr>
									<tr>
										<td colspan="3">
											<span class="required">*</span>필수입력사항
										</td>
									</tr>
								</thead>
								<!-- ////////////////////form item tbody//////////////////////////////////// -->
								<tbody>
									<!-- /////////아이디/////////// -->
									<tr>
										<th>
											아이디<span class="required">*</span>
										</th>
										<td>
											<input type="text" name="id" required="required">
										</td>
										<td>
											<button type="button" class="btn2-style">중복확인</button>
										</td>
									</tr>
									<!-- /////////비밀번호/////////// -->
									<tr>
										<th>
											비밀번호<span class="required">*</span>
										</th>
										<td>
											<input type="password" name="pw" placeholder="비밀번호">
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									
									<!-- /////////비밀번호확인/////////// -->
									<tr>
										<th>
											비밀번호확인<span class="required">*</span>
										</th>
										<td>
											<input type="password" name="pw2" placeholder="비밀번호를 한번 더 입력해주세요">
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////이름/////////// -->
									<tr>
										<th>
											이름<span class="required">*</span>
										</th>
										<td>
											<input type="text" name="name" placeholder="이름을 입력해주세요">
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////이메일/////////// -->
									<tr>
										<th>
											이메일<span class="required">*</span>
										</th>
										<td>
											<input type="email" name="email" placeholder="이메일을 입력해주세요">
										</td>
										<td><button type="button" class="btn2-style">중복확인</button></td>
									</tr>
									<!-- /////////휴대폰/////////// -->
									<tr>
										<th>
											휴대폰<span class="required">*</span>
										</th>
										<td>
											<input type="text" name="phone" placeholder="숫자만 입력해주세요">
										</td>
										<td><button type="button">인증번호받기</button></td>
									</tr>
									<!-- /////////주소/////////// -->
									<tr >
										<th>
											주소<span class="required">*</span>
										</th>
										<td class="addr">
											<!-- <button type="button" class="btn2-style"><i class="fas fa-search"></i>주소검색</button> -->
											<input type="text" name="addr" placeholder="주소를 입력해주세요">
											<p >배송지에 따라 상품 정보가 달라질 수 있습니다.</p>
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////성별/////////// -->
									<tr>
										<th>
											성별
										</th>
										<td class="gender">
											<span><input type="radio" id="gender1" name="gender" value="M"><label for="gender1">남자</label></span>
											<span><input type="radio" id="gender2" name="gender" value="F"><label for="gender2">여자</label></span>
											<span><input type="radio" id="gender3" name="gender" value="X" checked="checked"><label for="gender3">선택안함</label></span>
											
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////생년월일/////////// -->
									<tr>
										<th>
											생년월일
										</th>
										<td class="birth">
											<div class="flex center">
												<input type="text" name="year" size="4" maxlength="4" pattern="[0-9]{4}" placeholder="YYYY"><span>/</span>
												<input type="text" name="month" size="2" maxlength="2" pattern="[0-9]{2}" placeholder="MM"><span>/</span>
												<input type="text" name="day" size="2" maxlength="2" pattern="[0-9]{2}" placeholder="DD">
											</div>
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////추가입력사항/////////// -->
									<tr>
										<th>
											추가입력 사항
										</th>
										<td >
											<div class="flex between">
												<span><input type="radio" id="add1" name="add_item" value="recommend"><label for="add1">추천인 아이디</label></span>
												<span><input type="radio" id="add2" name="add_item" value="event"><label for="add2">참여 이벤트명</label></span>
											</div>
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
								</tbody>
															
							</table>
							<!-- ////////////////////이용약관동의 영역//////////////////////////////////// -->
							
							<div class="flex" id="terms">
								<div class="text">
									이용약관<span class="required">*</span>
								</div>	
								
								<ul class="check-items">
									<!-- //////전체동의///////// -->
									<li>
										<dl class="flex">
											<dt><input type="checkbox" id="all-check"></dt>
											<dd>
												<label class="all-check" for="all-check">전체 동의합니다.</label>
												<p class="guide">선택항목에 동의하지 않은 경우도 회원가입 및 일반적인 서비스를 이용할 수 있습니다.</p>
											</dd>
										</dl>
									</li>
									<!-- //////이용약관///////// -->
									<li>
										<dl class="flex">
											<dt><input type="checkbox" name="agree" value="t"></dt>
											<dd class="flex between">
												<p>이용약관 동의<span class="color9">(필수)</span></p>
												<a href="#" class="color-brand">약관보기&gt;</a>
											</dd>
										</dl>
									</li>
									<!-- //////개인정보(필수)///////// -->
									<li>
										<dl class="flex">
											<dt><input type="checkbox" name="private1" value="t"></dt>
											<dd class="flex between">
												<p>개인정보 수집·이용 동의<span class="color9">(필수)</span></p>
												<a href="#" class="color-brand">약관보기&gt;</a>
											</dd>
										</dl>
									</li>
									<!-- //////개인정보(선택)///////// -->
									<li>
										<dl class="flex">
											<dt><input type="checkbox" name="private2"></dt>
											<dd class="flex between">
												<p>개인정보 수집·이용 동의<span class="color9">(선택)</span></p>
												<a href="#" class="color-brand">약관보기&gt;</a>
											</dd>
										</dl>
									</li>
									<!-- //////무료배송///////// -->
									<li>
										<dl class="flex">
											<dt><input type="checkbox" name="marketing" value="t"></dt>
											<dd >
												<p>무료배송,할인쿠폰 등 혜택/정보 수신 동의<span class="color9">(선택)</span></p>
												<div class="sms-email">
													<span>
														<input type="checkbox" name="sms" value="t">
														<label>SMS</label>
													</span>
													<span class="check-email" name=mailing value="t">
														<input type="checkbox" value="t">
														<label>이메일</label>
													</span>
												</div>
												<p class="guide sms">
													<span>L</span>
													<span class="color-brand">동의 시 한달간[5%적립]+[무제한 무료배송]</span>
													<span class="color9">(첫 주문 후 적용)</span>
												</p>
											</dd>
										</dl>
									</li>
									<!-- /////14세///////// -->
									<li>
										<dl class="flex">
											<dt><input type="checkbox" name="fourteen_chk" value="t"></dt>
											<dd class="flex between">
												<p>본인은 만 14세 이상입니다.<span class="color9">(필수)</span></p>
											</dd>
										</dl>
									</li>
								</ul>
							</div>
							<!-- ////////////////////가입하기 버튼 영역//////////////////////////////////// -->
							<div class="btn-submit flex center">
								<button type="submit" class="btn-style">가입하기</button>
							</div>	
						</form>
					</div>
				</section>
			</div>
		</main>
	</body>
</html>