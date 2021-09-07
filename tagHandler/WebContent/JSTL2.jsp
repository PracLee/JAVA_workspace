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
	<c:set var="msg" value="user" />
	<c:if test="${msg=='test' }" var="res">
	1 - 결과는 [${res }]입니다.
	</c:if>
	<!--
	test는 필수 속성!
	else는 지원하지 않음!
	  -->
	<c:if test="${msg!='test' }" var="res">
	2 - 결과는 [${res }]입니다.
	</c:if>
	<!-- 
	else를 지원하지 않기때문에 반대상황을 만들어주어야한다
	주로 관리자임을 물어볼때 사용!
	 -->
</body>
</html>