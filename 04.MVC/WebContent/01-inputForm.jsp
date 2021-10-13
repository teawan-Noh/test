<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿으로 값 전송</title>
</head>
<body>

	<h4>The input Element 1) - type: text,password, reset, submit</h4>
	<form method="post" action="input_element1">
		User name: <br/> <input type="text" name="name"/><br/>
		User password: <br/> <input type="password" name="password"/><br/>
		<input type="reset"> <input type="submit" value="Submit"/>
	</form>
	
	<h4>The input Element 1) - type: radio</h4>
	<form method="post" action="input_element2">
		<input type="radio" name="gender" value="male"/> Male <br/>
		<input type="radio" name="gender" value="female"/> Female <br/>
		<input type="radio" name="gender" value="other"/> Other <br/>
		<input type="submit" value="Submit"/>
	</form>
	
	<h4>The input Element 1) - type: checkbox</h4>
	<form method="post" action="input_element3">
		<input type="checkbox" name="vehicle" value="bike"/> 자전거 <br/>
		<input type="checkbox" name="vehicle" value="car"/> 자동차 <br/>
		<input type="submit" value="Submit"/>
	</form>
	
	<h4>The select Element</h4>
	<form method="post" action="select_element">
		<select name="cars">
		  	<option value='volvo'>Volvo</option>
		  	<option value='saab'>Saab</option>
		  	<option value='flat'>Flat</option>
		  	<option value='audi'>Audi</option>
		</select>
		<input type="submit" value="Submit"/>
	</form>
	
	<h4>The textarea Element</h4>
	<form method="post" action="textarea_element">
		<textarea name="message" rows="10" cols="30">이곳에 값을 넣어요~</textarea>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>