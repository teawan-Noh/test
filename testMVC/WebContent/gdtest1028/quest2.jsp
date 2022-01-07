<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$(".box button").attr("disabled", true);
	$(".del-chk").on('click',function(){
        var chk = $('input:radio[class="del-chk"]').is(":checked");
        if(chk==true){
            $(".box button").removeAttr('disabled');
            $(".box").removeClass("on");
        }else{
            $(".box button").attr("disabled", true);
            $(".box").addClass("on");
        }
    });
	
});
</script>
<style type="text/css">
	span{
		font-size: 0.5rem;
		color: gray;
	}
	.font{
		font-weight: bold;
	}
	.box{
		padding-top: 10px;
	}
</style>
</head>
<body>
<div class="container mt-3">
	<h2>주문/결제</h2>
	<table class="table">
		<thead>
	      	<tr>
	        	<th></th>
	        	<th></th>
	        	<th></th>
	      	</tr>
	    </thead>
	    <tbody>
		    <tr>
		    	<td><img src="../img/java.jpg" class="rounded" alt="java" width="77" height="90"></td>
		      	<td>자바</td>
		      	<td>1000/<span>수량2</span></td>
		    </tr>
	    	<tr>
	     		<td><img src="../img/spring.jpg" class="rounded" alt="spring" width="77" height="90"></td>
		      	<td>스프링</td>
		      	<td>10000/<span>수량1</span></td>
	    	</tr>
	    </tbody>
	</table>
	<table class="table">
		<thead>
	      	<tr>
	        	<th></th>
	        	<th></th>
	        	<th></th>
	      	</tr>
	    </thead>
	    <tbody>
		    <tr>
		    	<td class="font">주문고객</td>
		      	<td>홍길동</td>
		    </tr>
	    	<tr>
	     		<td class="font">연락처</td>
		      	<td>01072728888</td>
	    	</tr>
	    	<tr>
	     		<td class="font">배송지</td>
		      	<td>구디빌딩 11층</td>
	    	</tr>
	    </tbody>
	</table>
	<h5>총합계액</h5>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" value="12000" disabled/>
	</div>
	<div>
		<input type="radio" name="radio" class="del-chk"/>카드결제
		<input type="radio" name="radio" class="del-chk"/>통장이체
	</div>
	<div class="box">
		<button type="button" class="btn btn-primary">결제하기</button>
	</div>
</div>
	
</body>
</html>