<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script type="text/javascript">
  var deptno = "${empDetail.deptno}";
	
	$('select option').each(function(){
		if(deptno == $(this).val()){
			$(this).attr('selected','selected')
		}
	});
  </script> -->
</head>
<body>
<div class="container mt-3" >	
	
	<h3>emp</h3>
		<form method="post" action="emp_update"> 
		사원번호 : ${empDetail.empno} <br/>
		<input type="text" name="empno" value="${empDetail.empno}" hidden="hidden"/>
		사원이름 : ${empDetail.ename} <br/>
		<input type="text" name="ename" value="${empDetail.ename}" hidden="hidden"/>
		업무: <input type="text" name="job" value="${empDetail.job}"/> <br/>
		매니저 : <input type="text" name="mgr" value="${empDetail.mgr}"/> <br/>
		고용일 : <input type="text" name="hiredate" value="${empDetail.hiredate}"/> <br/>
		급여 : <input type="text" name="sal" value="${empDetail.sal}"/> <br/>
		상여 : <input type="text" name="comm" value="${empDetail.comm}"/> <br/>
		부서 : <input type="text" name="deptno" value="${empDetail.deptno}"/> <br/>
			<!-- <select name="deptno">
			  			<option value='10'>개발팀</option>
			  			<option value='20'>인사팀</option>
			  			<option value='30'>재무팀</option>
					</select>  <br/> -->
		<input type="submit" value="수정"/>
	</form>
	<br/>
</div>
</body>
</html>