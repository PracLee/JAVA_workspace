<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ID }로쓴글 목록</title>
</head>
<body>
	<form action="ctrl.jsp?action=IDPWcheck" method="post">
		<table>
			<tr>
				<th>글번호</th>
				<th>내용</th>
			</tr>
			<c:forEach var="v" items="${datas }">
				<tr>
					<td>${v.cNum }</td>
					<td>${v.com }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<a href="index.jsp">처음으로</a>
</body>
</html>