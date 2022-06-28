<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/member.css">
		<script type="text/javascript">
		$(function(){
			$(function(){
				var msg="${changedPw}";
				if(msg!=""){
					alert(msg);
				}
			});
			
		});
	</script>
	</head>
	<body>
		<!-- header.jsp -->
		<jsp:include page="/WEB-INF/view/common/header.jsp" />
		<main>
			<h1>메인영역</h1>
			<div class="wrap">
				<section id="form">
					<h1>회원정보확인</h1>
					
					<script type="text/javascript">
						
						
						////////////////////////
						function pwCheck(){
							//기존비밀번호 와 뉴 비밀번호 일치여부
							var pw="${detail.pw}";
							var newPw=$.trim($("#new-pw").val()); //새로입력한 비번
							
							if(pw!=newPw){
								return true;
							}
							//비밀번호가 같으면
							$("#new-pw").next().text("기존 비밀번호와 동일합니다.");
							return false;
						}
					</script>
					<div class="wrap">
						<form action="update" method="post" onsubmit="return pwCheck()">
							<table>
								<thead>
									<tr>
										<th colspan="3">
											<span>회원정보확인</span>
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
											아이디
										</th>
										<td>
											<input type="text" value="${detail.id }"  disabled="disabled">
										</td>
										<td></td>
									</tr>
									
									
									<!-- /////////비밀번호 변경시/////////// -->
									<tr>
										<th>
											비밀번호 변경
										</th>
										<td>
											<input type="password" name="newPw" id="new-pw"  placeholder="새로운 비밀번호 설정">
											<p style="color: red;font-size: 14px;"></p>
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////이름/////////// -->
									<tr>
										<th>
											이름
										</th>
										<td>
											<input type="text" value="${detail.name }" disabled="disabled">
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
									<!-- /////////이메일/////////// -->
									<tr>
										<th>
											이메일
										</th>
										<td>
											<input type="email" value="${detail.email }" >
										</td>
										<td><button type="button" class="btn2-style">중복확인</button></td>
									</tr>
									<!-- /////////휴대폰/////////// -->
									<tr>
										<th>
											휴대폰
										</th>
										<td>
											<input type="text" value="${detail.phone }">
										</td>
										<td></td>
									</tr>
									<!-- /////////주소/////////// -->
									<tr >
										<th>
											주소
										</th>
										<td class="addr">
											
											<input type="text" value="${detail.addr }">
											<p >배송지에 따라 상품 정보가 달라질 수 있습니다.</p>
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
												<input  type="text" value="${detail.birth }">
											
											</div>
										</td>
										<td><!-- 버튼없음 --></td>
									</tr>
								</tbody>
							</table>
							<!-- ///수정 -->
							<div>
								 <%-- <input type="hidden" name="no" value="${detail.no }"> --%>
								 <button type="submit">비밀번호 수정</button>
								 <a href="delete"><button type="button">회원탈퇴</button></a>
							</div>
						</form>
					</div>
				</section>
			</div>
		</main>
	</body>
	
</html>