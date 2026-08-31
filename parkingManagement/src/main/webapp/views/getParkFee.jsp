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

로그인 해주세요. 회원만이 이용 가능합니다.
<a href="/userEntry">회원가입</a>&nbsp;&nbsp;<a href="/userLogin">로그인하기</a>
</c:when>
<c:otherwise>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<p>어서오세요. ${ sessionScope.username } 님 </p> &nbsp;&nbsp; <a href="/userLogout/do">로그아웃하기</a>

	<c:choose>
		<c:when test="${ sessionScope.userparkflag eq null }">
			주차하신 손님만 주차요금 정산을 해드릴 수 있어요.
			<br/><a href="/">홈으로</a>
		</c:when>
		<c:otherwise>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			주차 시작 시간은 ${ carInTime } <br/>
			현재 시간은 ${ nowTime } <br/>
			<br/>
			현재 지불하실 예상 주차요금은 ${ fee }원입니다. <br/>
			30분 = 4000원<br/>
			30분 이전 출차 시 조출 할인 2000원 적용됩니다.<br/>
			<br/>
			정산하시겠습니까? 아니오를 누르시면 홈으로 돌아갑니다.<br/>
			<button type="button" onclick="doCheckoutPark()">예</button><button type="button" onclick="doReturnHome()">아니오</button>	
			
		</c:otherwise>
	</c:choose>


</c:otherwise>
</c:choose>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


</body>

<script type="text/javascript">
function doCheckoutPark(){
	
	location.href="/doCheckout";
}
function doReturnHome(){
	
	location.href="/";
}
</script>

</html>