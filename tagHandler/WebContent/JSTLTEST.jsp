<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="number" name="num"> <input type="submit" value="짝홀 판별!">
	</form>
	<br>
	<c:if test="${param.num%2==0 }">
	짝수입니다!
	</c:if>
	<c:if test="${param.num%2==1 }">
	홀수입니다!
	</c:if>
	<%
	ArrayList<String> datas = new ArrayList();
	datas.add("str1");
	datas.add("str2");
	datas.add("str3");
	pageContext.setAttribute("datas", datas);
	%>
	<c:forEach var="v" items="${datas }">
		<p>${v }</p>
	</c:forEach>
</body>
</html>