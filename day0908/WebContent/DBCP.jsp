<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, model.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP실습!</title>
</head>
<body>
	<form method="post" action="ctrl.jsp?action=insert">
		<table>
			<tr>
				<td><input type="text" name="com" placeholder="내용입력(300자까지)">
				</td>
				<td><input type="text" name="ID" placeholder="ID입력"></td>
				<td><input type="password" name="PW" placeholder="PW입력">
				</td>
				<td><input type="submit" value="댓글입력하기!"></td>
			</tr>
		</table>
		<hr>
	</form>
	<form method="post" action="ctrl.jsp?action=find">
		<table>
			<tr>
				<td><input type="text" name="ID" placeholder="찾는 ID"></td>
				<td><input type="submit" value="글쓴 사람 검색!"></td>
			</tr>
		</table>
		<hr>
	</form>
	<table>
		<tr>
			<th>글번호</th>
			<th>내용</th>
			<th>작성자ID</th>
			<th>수정·삭제하려면 비밀번호를 입력해주세요!</th>
			<th>수정·삭제</th>
		</tr>
		<c:forEach var="v" items="${datas }">
			<form action="ctrl.jsp?action=IDPWcheck" method="post">
			<tr>
				<td>${v.cNum }</td>
				<td>${v.com }</td>
				<td>${v.ID }</td>
				<td><input type="password" placeholder="수정·삭제하려면 비밀번호를 입력해주세요!"
					name="PWcheck"></td>
				<td><input type="submit" value="수정·삭제"></td>
				<input type="hidden" value="${v.cNum }" name="cNum">
				<input type="hidden" value="${v.com }" name="com">
				<input type="hidden" value="${v.PW }" name="PW">
			</tr>
			</form>
		</c:forEach>
	</table>
</body>
</html>