<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="/userEntry/do" method="POST" onSubmit="return checkForm(this)" modelAttribute="userDTO">
	ID : <input type="text" name="userID">&nbsp;&nbsp;<form:errors path="userID" style="color:red;"/><br/>
	PWD : <input type="password" name="userPWD">&nbsp;&nbsp;<form:errors path="userPWD" style="color:red;"/><br/>
	이름 : <input type="text" name="userName"><br/>
	차량 번호: <input type="text" name="userCarNum">&nbsp;&nbsp;<form:errors path="userCarNum" style="color:red;"/><br/>
	<input type="checkbox" name="userParkFlag" hidden="hidden" checked="checked" value="0">
	등록하기 <input type="submit" value="회원가입">

</form:form>

<%-- 
<form action="/userEntry/do" method="POST" onSubmit="return checkForm(this)">
	ID : <input type="text" name="userID">
	PWD : <input type="password" name="userPWD">
	이름 : <input type="text" name="userName">
	차량 번호: <input type="text" name="userCarNum">
	<input type="checkbox" name="userParkFlag" hidden="hidden" checked="checked" value="0">
	등록하기 <input type="submit" value="회원가입">
	
</form>
 --%>

</body>
<script type="text/javascript">
function checkForm(f){
	
	if(f.userID.value.trim() === ""){
		
		alert('ID를 입력하세요.');
		return false;
	}
	
	
	if(f.userPWD.value.trim() === ""){
		
		alert('비밀번호를 입력하세요.');
		return false;
	}
	
	if(f.userName.value.trim() === ""){
		
		alert('이름을 입력하세요.');
		return false;
	}
	
	if(f.userCarNum.value.trim() === ""){
		
		alert('차량 번호를 입력하세요.');
		return false;
	}
}

</script>

</html>