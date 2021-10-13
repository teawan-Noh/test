<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- jquery, bootstrap 지원 -->
	<jsp:include page="../common/bootstrapInclude.jsp"/>
	<!-- 다음 우편번호 api 사용  -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/06.memberManage/js/daumPostcode.js"></script>
</head>
<body>
<div class="container mt-3" >	
	
	<h3>회원정보수정</h3>
		<form method="post" action="customer_update">
		ID : ${customerInfo.id}
		<input type="text" name="id" value="${customerInfo.id}" hidden="hidden"/> <br/>
		이름 : ${customerInfo.name}
		<input type="text" name="name" value="${customerInfo.name}" hidden="hidden"/> <br/>
		<input type="text" name="password" placeholder="비밀번호를 입력하세요"> <br/>
		<input type="text" name="password" placeholder="확인 비밀번호를 입력하세요"> <br/>
		<input type="text" id="sample6_postcode" name="postcode" placeholder="우편번호">
		<input type="button" class="btn btn-primary" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br/>
		<input type="text" id="sample6_address" name="address" placeholder="주소">
		<input type="text" id="sample6_detailAddress" name="address2" placeholder="상세주소"><br/>
		<input type="text" id="sample6_extraAddress" placeholder="참고항목"> <br/>
		<input type="text" name="phone" value="${customerInfo.phone}"> <br/>
		<input type="text" name="email" value="${customerInfo.email}"> <br/>
		<input type="submit" value="수정"/>
	</form>
	<a href="memo_delete?memoid=${memodetail.memoid}">삭제</a>
</div>
</body>
</html>