<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const parkList=[
	<c:forEach items="${ list }" var="li" varStatus="status">
		{
			parkfloor : "${ li.parkFloor }",
			parknum : "${ li.parkNum }",
			parkflag : ${ li.parkFlag }
			
		}
		<c:if test="${ !status.last }">,</c:if>
	
	</c:forEach>
];



</script>
</head>


<body>

<c:choose>
<c:when test="${ sessionScope.username eq null }">
<br/>
<br/>
<br/>
<br/>
<br/>
로그인 해주세요. 회원만이 이용가능한 서비스입니다.
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<p>어서오세요. ${ sessionScope.username } 님 </p> &nbsp;&nbsp; <a href="/userLogout/do">로그아웃하기</a>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
	<form action="/reserv/do" method="post" onSubmit="return check(this)">
		<select id="parkFloor" name="parkFloor" onChange="toggleSelect()">
			<option selected="selected" value="">----예약하고자하는 주차 층계 선택----</option>
			<option value="1층">1</option>
			<option value="2층">2</option>
			<option value="3층">3</option>
			<option value="4층">4</option>
			<option value="5층">5</option>
			<option value="6층">6</option>
			
		</select>
		<select id="parkNum" hidden="hidden" name="parkNum">
			<option selected="selected" value="">----예약하고자하는 주차 번호 선택----</option>
			
			
		</select>
		<input type="submit" value="주차예약">		
		
	</form>

</c:otherwise>
</c:choose>

</body>
<script type="text/javascript">
function check(f){
	
	if(f.parkFloor.value === ""){
		
		alert("예약하실 주차 층계를 선택해주세요.");
	}
	if(f.parkNum.value === ""){
		
		alert("예약하실 주차 번호를 선택해주세요.");
	}
}

function toggleSelect(){
	const floorVal = document.getElementById('parkFloor').value;
	document.getElementById('parkNum').innerHTML='<option selected="selected" value="">----예약하고자하는 주차 번호 선택----</option>';
	
	if(floorVal !== ""){
			
		document.getElementById('parkNum').removeAttribute("hidden");
		
		switch(floorVal){
		case "1층": 
			
			
			for(li of parkList){
				if(parseInt(li.parkfloor) === 1){
				
					if(li.parkflag === false){
						
						continue;
					}
					const option = document.createElement("option");
					option.value = li.parknum;
					option.textContent = li.parknum;
					document.getElementById('parkNum').appendChild(option);
				}
			}
			
			break;
		case "2층": 
			for(li of parkList){
				if(parseInt(li.parkfloor) === 2){
					if(li.parkflag === false){
						
						continue;
					}
					const option = document.createElement("option");
					option.value = li.parknum;
					option.textContent = li.parknum;
					document.getElementById('parkNum').appendChild(option);
				}
			}
			break;
		case "3층": 
			for(li of parkList){
				if(parseInt(li.parkfloor) === 3){
					if(li.parkflag === false){
						
						continue;
					}
					const option = document.createElement("option");
					option.value = li.parknum;
					option.textContent = li.parknum;
					document.getElementById('parkNum').appendChild(option);
				}
			}
			break;
		case "4층": 
			for(li of parkList){
				if(parseInt(li.parkfloor) === 4){
					if(li.parkflag === false){
						
						continue;
					}
					const option = document.createElement("option");
					option.value = li.parknum;
					option.textContent = li.parknum;
					document.getElementById('parkNum').appendChild(option);
				}
			}
			break;
		case "5층": 
			for(li of parkList){
				if(parseInt(li.parkfloor) === 5){
					if(li.parkflag === false){
						
						continue;
					}
					const option = document.createElement("option");
					option.value = li.parknum;
					option.textContent = li.parknum;
					document.getElementById('parkNum').appendChild(option);
				}
			}
			break;
		case "6층": 
			for(li of parkList){
				if(parseInt(li.parkfloor) === 6){
					if(li.parkflag === false){
						
						continue;
					}
					const option = document.createElement("option");
					option.value = li.parknum;
					option.textContent = li.parknum;
					document.getElementById('parkNum').appendChild(option);
				}
			}
			break;
		}
	}
	else {
			
		
		document.getElementById('parkNum').setAttribute("hidden", "");
	}
	
}
</script>
</html>