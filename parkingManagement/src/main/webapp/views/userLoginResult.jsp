<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${ sessionscope eq null }">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/userLogin">로그인하기</a>
<br/>
로그인에 실패했습니다.
<a href="/">홈으로</a>
<br/>
<a href="userLogin">다시 로그인하러 가기</a>
</c:when>
<c:otherwise>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <p>어서오세요. ${ sessionScope.username } 님 </p> &nbsp;&nbsp; <a href="/userLogin">로그아웃하기</a>

<br/>
로그인 성공했습니다.
<br/>
<a href="/">홈으로</a>
</c:otherwise>
</c:choose>



</body>
</html>