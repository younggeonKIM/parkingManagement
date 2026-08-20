<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/parkEntry/do" method="POST" onSubmit="return checkForm(this)">
	주차 층계 : <input type="text" name="parkFloor">
	주차장 번호 : <input type="text" name="parkNum" size="3">
	
	등록하기 <input type="submit">
	
</form>


</body>
<script type="text/javascript">
function checkForm(f){
	
	if(f.parkFloor.value==""){
		
		alert('주차 층계를 입력하세요.');
		return false;
	}
	if(isNaN(f.parkFloor.value)){
		
		alert('주차 층계는 숫자로만 입력해주세요.');
		return false;
	}
	if(f.parkFloor.value > 6){
		
		alert('주차 층계는 6이하의 숫자로만 입력해주세요.');
		return false;
	}
	if(f.parkNum.value.trim()===""){
		
		alert('주차장 번호를 입력하세요.');
		return false;
	}
}

</script>

</html>