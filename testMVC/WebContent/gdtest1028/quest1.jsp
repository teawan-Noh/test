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
	
	$(document).on('click','#chk_all',function(){
	    if($('#chk_all').is(':checked')){
	       $('.del-chk').prop('checked',true);
	    }else{
	       $('.del-chk').prop('checked',false);
	    }
	});
	
	$(document).on('click','.del-chk',function(){
	    if($('input[class=del-chk]:checked').length==$('.del-chk').length){
	        $('#chk_all').prop('checked',true);
	    }else{
	       $('#chk_all').prop('checked',false);
	    }
	});
	
	$(".box button").attr("disabled", true);
	$(".del-chk").on('click',function(){
        var chk = $('input:checkbox[class="del-chk"]').is(":checked");
        if(chk==true){
            $(".box button").removeAttr('disabled');
            $(".box").removeClass("on");
        }else{
            $(".box button").attr("disabled", true);
            $(".box").addClass("on");
        }
    });
	
	$("#chk_all").on('click',function(){
        var chkall = $('input:checkbox[id="chk_all"]').is(":checked");
        if(chkall==true){
            $(".box button").removeAttr('disabled');
            $(".box").removeClass("on");
        }else{
            $(".box button").attr("disabled", true);
            $(".box").addClass("on");
        }
    });
});
</script>
</head>
<body>
<div class="container mt-3">
	<h2>장바구니</h2>
	<table class="table">
		<thead>
	      	<tr>
	        	<th><input type="checkbox" id="chk_all">전체</th>
	        	<th>책이름</th>
	        	<th>출판사</th>
	        	<th>가격</th>
	        	<th>수량</th>
	      	</tr>
	    </thead>
	    <tbody>
		    <tr>
		    	<td><input type="checkbox" class="del-chk"></td>
		      	<td>자바</td>
		      	<td>오렌지</td>
		      	<td>1000</td>
		      	<td>2</td>
		    </tr>
	    	<tr>
	     		<td><input type="checkbox" class="del-chk"></td>
		      	<td>스프링</td>
		      	<td>자두</td>
		      	<td>10000</td>
		      	<td>1</td>
	    	</tr>
	    </tbody>
	</table>
	<h5>총합계액</h5>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" disabled/>
	</div>
	<div class="box">
		<button type="button" class="btn btn-primary">선택상품구매하기</button>
	</div>
</div>
	
</body>
</html>