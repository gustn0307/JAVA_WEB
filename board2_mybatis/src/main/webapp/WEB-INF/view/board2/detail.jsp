<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="${ROOT }/css/board2/list.css">
		
	</head>
	<body>
		<!-- header가 들어갈영역 -->
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
		<main>
			<h1>컨텐츠영역</h1>
			<div class="wrap view-width">
				<section id="write-form">
					<h1>상세페이지</h1>
					<div class="wrap ">
						<p class="tit">상세 페이지</p>
						<div>
							<script type="text/javascript">
								$(function(){
									//수정버튼 클릭시
									$("#btn-edit").click(function(){
										$("#tbl").hide();
										$("#edit-form").show();
									});
									//수정취소 눌렀을때
									$("#btn-cancle").click(function(){
										$("#tbl").show();
										$("#edit-form").hide();
									});
									
								});
							</script>
							<table id="tbl" border="1" style="border-collapse: collapse;">
								<tr>
									<td>no</td>
									<td colspan="3" id="no">${detail.no }</td>
								</tr>
								<tr>
									<td>작성자</td>
									<td>${detail.writer }</td>
									<td>작성일</td>
									<td>${detail.created_date }</td>
								</tr>
								<tr>
									<td>제목</td>
									<td colspan="3">
										<span>${detail.subject }</span>&nbsp;&nbsp;(<span>${detail.read_count }</span>)
									</td>
								</tr>
								<tr>
									<td>내용</td>
									<td colspan="3">
										${detail.content }
									</td>
								</tr>
								
								<tr>
									<td colspan="4">
										<script type="text/javascript">
											function del(){
												var result=confirm("정말로 삭제 하시겠습니까?");
												if(result==true){//삭제 처리
													//console.log("삭제처리하세요");
													location.href="delete?no=${detail.no}";
													//location.href="delete?no="+document.getElementById("no").innerText;
													//location.href="delete?no="+$("#no").text();
													return;
												}
												//console.log("삭제처리 취소합니다.");
											}
										</script>
										<button id="btn-edit" type="button">수정</button>
										<button type="button" onclick="del()">삭제</button>
										<a href="list"><button type="button">목록보기</button></a>
									</td>
									
								</tr>
							</table>
							<script type="text/javascript">
								function checkForm(){
									
									var old_sub="${detail.subject }";
									var new_sub=$("#subject").val().trim();
									var old_con="${detail.content }";
									var new_con=$("#content").val().trim();
									
									//2.수정한내용이 "" 비어있는경우
									if(new_sub=="" || new_con==""){
										alert("제목 이나 내용이 비어있어요");
										return false;
									}
									//1.제목과 내용이 수정이 않되었는지 체크
									if(old_sub == new_sub && old_con == new_con){
										alert("변경내용이 없습니다.");
										return false;
									}
									
									return true;									
								}
							</script>
								                                                               <!-- checkForm()함수를 실행해서 return결과가 true일때 submit처리 false이면 submit취소 -->
							<form id="edit-form" style="display: none;" action="update" method="post"  onsubmit="return checkForm()">
								<table border="1" style="border-collapse: collapse;">
									<tr>
										<td>no</td>
										<td colspan="3" id="no">${detail.no }</td>
									</tr>
									<tr>
										<td>작성자</td>
										<td>${detail.writer }</td>
										<td>작성일</td>
										<td>${detail.created_date }</td>
									</tr>
									<tr>
										<td>제목</td>
										<td colspan="3">
										<span><input type="text" name="subject" id="subject" value="${detail.subject }"></span>&nbsp;&nbsp;(<span>${detail.read_count }</span>)
										</td>
									</tr>
									<tr>
										<td>내용</td>
										<td colspan="3">
											<textarea rows="5" cols="50" name="content" id="content" >${detail.content }</textarea>
										</td>
									</tr>
	
									<tr>
										<td colspan="4">
											<input type="hidden" name="no" value="${detail.no }">
											<button type="submit">수정완료</button>
											<button id="btn-cancle" type="button">수정취소</button>												 
											<a	href="list"><button type="button">목록보기</button></a>
										</td>
									</tr>
								</table>

							</form>
						</div>
					</div>
				</section>
				
			</div>
		</main>
		<!-- footer.jsp파일을 여기에 포함시키세요 -->
		<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	</body>
</html>