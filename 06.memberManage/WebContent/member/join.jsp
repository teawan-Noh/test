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
	
<script type="text/javascript">
$(function(){
	
	$(chekcid).click(
		function(){
			//사용자가 입력한값 얻어오기
			var input_value = $("input[name='id']").val();

		//입력여부 검사
			if(!input_value){
				alert("아이디를 입력하세요.");
				$("input[name='id']").focus();
				return false;
			}
			
			var url = "idcheck";
			/* ajax 처리 id_value(controller의 id): input_value(파라미터) , data:응답(xml문서) */
			$.get(url, {"id_value" : input_value},function(data){
				//alert(data)
				var result_text = $(data).find("result").text(); //응답받은 xml문서에서 result 태그를 발견해라
				//alert(result_text);
				
				var result = eval(result_text);
				
				if(result){
					$(".console").html("<h6>사용가능</h6>")
				}else{
					$(".console").html("<h6>사용불가</h6>")
				}
			});
	});
});
</script>
<style>
	input{
		padding: 3px;
		margin: 5px;
		width: 300px;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<form method="post" action="customer_save">
			<input type="text" name="id" placeholder="아이디를 입력하세요"> 
			<button id="chekcid" type="button" class="btn btn-primary">중복체크</button> <br/>
			<div class="console"></div>
			
			<input type="text" name="password" placeholder="비밀번호를 입력하세요"> <br/>
			<input type="text" name="password" placeholder="확인 비밀번호를 입력하세요"> <br/>
			<input type="text" name="name" placeholder="이름을 입력하세요"> <br/>
			<input type="text" id="sample6_postcode" name="postcode" placeholder="우편번호">
			<input type="button" class="btn btn-primary" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br/>
			<input type="text" id="sample6_address" name="address" placeholder="주소">
			<input type="text" id="sample6_detailAddress" name="address2" placeholder="상세주소"><br/>
			<input type="text" id="sample6_extraAddress" placeholder="참고항목"> <br/>
			<input type="text" name="phone" placeholder="폰번호 입력하세요"> <br/>
			<input type="text" name="email" placeholder="이메일을 입력하세요"> <br/>
			<button type="submit" class="btn btn-primary">가입</button> <br/>
		</form>
	</div>
</body>
</html>