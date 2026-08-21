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


	<!-- 	기존 내가 짰던 코드 -->
	<%-- <table>
		<c:forEach items="${ parkList }" var="park">		
			<c:choose>
				<c:when test="${ park.parkFloor } == 1">
					<tr><td>1층
					<c:forEach items="${ parkList }" var="park">
			
						
					
						<th>${ park.parkNum }</th>
					</c:forEach>
					</td></tr>
				</c:when>
				<c:when test="${ park.parkFloor } == 2">
					<tr><td>1층
					<c:forEach items="${ parkList }" var="park">
			
						
					
						<th>${ park.parkNum }</th>
					</c:forEach>
					</td></tr>
				</c:when>				
			</c:choose>
		</c:forEach>
	</table> --%>


<table>
    <!-- 1층 행 -->
    <tr>
        <th>1층</th>
        <c:forEach items="${ parkList }" var="park">
            <!-- EL 표현식 내부{ } 안에서 비교 연산을 해야 합니다 -->
            <c:if test="${ park.parkFloor == 1 }">
                <td><a href="/park/id/1/${ park.parkNum }">${ park.parkNum }</a></td>
            </c:if>
        </c:forEach>
    </tr>

    <!-- 2층 행 -->
    <tr>
        <th>2층</th>
        <c:forEach items="${ parkList }" var="park">
            <c:if test="${ park.parkFloor == 2 }">
                <td><a href="/park/id/2/${ park.parkNum }">${ park.parkNum }</a></td>
            </c:if>
        </c:forEach>
    </tr>
    
    <!-- 3층 행 -->
    <tr>
        <th>3층</th>
        <c:forEach items="${ parkList }" var="park">
            <c:if test="${ park.parkFloor == 3 }">
                <td><a href="/park/id/3/${ park.parkNum }">${ park.parkNum }</a></td>
            </c:if>
        </c:forEach>
    </tr>
    
    <!-- 4층 행 -->
    <tr>
        <th>4층</th>
        <c:forEach items="${ parkList }" var="park">
            <c:if test="${ park.parkFloor == 4 }">
                <td><a href="/park/id/4/${ park.parkNum }">${ park.parkNum }</a></td>
            </c:if>
        </c:forEach>
    </tr>
    
    <!-- 5층 행 -->
    <tr>
        <th>5층</th>
        <c:forEach items="${ parkList }" var="park">
            <c:if test="${ park.parkFloor == 5 }">
                <td><a href="/park/id/5/${ park.parkNum }">${ park.parkNum }</a></td>
            </c:if>
        </c:forEach>
    </tr>
    
    <!-- 6층 행 -->
    <tr>
        <th>6층</th>
        <c:forEach items="${ parkList }" var="park">
            <c:if test="${ park.parkFloor == 6 }">
                <td><a href="/park/id/6/${ park.parkNum }">${ park.parkNum }</a></td>
            </c:if>
        </c:forEach>
    </tr>
    
</table>
<br/>
<a href="/">홈으로</a>

<c:if test="${ sessionScope.userID eq 'admin' }">
	<p id="parkEntry">
	
	</p>
</c:if>

</body>

<script type="text/javascript">


function doParkEntry(){
	
	document.getElementById('parkEntry').innerHTML='<a href="/parkEntry">주차장 추가하기</a>';
}
doParkEntry();
</script>

</html>