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
<c:when test="${ sessionScope.username eq null }">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/userLogin">로그인하기</a>
</c:when>
<c:otherwise>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <p>어서오세요. ${ sessionScope.username } 님 </p> &nbsp;&nbsp; <a href="/userLogout/do">로그아웃하기</a>

	

</c:otherwise>
</c:choose>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


주차장 번호가 등록됐습니다. 
${ parkFloor } 층에 ${ parkNum } 번호 등록됨. 
<br/>
<a href="/">홈으로</a>
</body>
</html>