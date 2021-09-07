<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:catch var="errMsg">
	<%=10/0 %>
	</c:catch><!-- 태크바디에서 일어나는 에러를 잡아준다
	 c:catcn보다 isErrorPage를 주로 사용-->
	${errMsg }
	<c:set var="msg" value="안녕하세요!" />
	<c:remove var="msg"/><!-- 변수 지우기 -->
	<h1>${msg}</h1>
	<%=pageContext.getAttribute("msg") %>
	<!-- 스크립트릿 이용하여 변수 msg 출력 -->
	<!-- 
	변수를 저장하여 c:out이나 EL로 출력할수 있음
	EL을 주로 사용함
	Scope를 정할수 있지만, 주로 페이지 내부에서 사용되기 때문에 잘 쓰지 않는다.
	 -->
	<c:set target="${member}" property="email" value="mrgoga@naver.com" /><!-- ==member.setEmail -->
	${member.name }
	<br> ${member.email }
</body>
</html>