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
<c:choose>
	<c:when test="${ sessionScope.username ne null }">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <p>어서오세요. ${ sessionScope.username } 님 </p> &nbsp;&nbsp; <a href="/userLogout/do">로그아웃하기</a>
	<br/>
	<a href="/">홈으로</a>
	
	</c:when>
	<c:otherwise>
	
	
	
	<br/>
	로그인에 실패했습니다.
	<br/>
	<a href="/">홈으로</a>
	<br/>
	<a href="/userLogin">다시 로그인하러 가기</a>
	</c:otherwise>
</c:choose>



</body>
</html>