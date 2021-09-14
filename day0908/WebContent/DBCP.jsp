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
		<c:forEach var="cr" items="${datas }">
			<form action="ctrl.jsp?action=IDPWcheck" method="post">
				<tr>
					<td>${cr.c.cNum }</td>
					<td>${cr.c.com }</td>
					<td>${cr.c.ID }</td>
					<td><input type="password"
						placeholder="수정·삭제하려면 비밀번호를 입력해주세요!" name="PWcheck"></td>
					<td><input type="submit" value="수정·삭제"></td>
					<input type="hidden" value="${cr.c.cNum }" name="cNum">
					<input type="hidden" value="${cr.c.com }" name="com">
					<input type="hidden" value="${cr.c.PW }" name="PW">
				</tr>
			</form>
			<c:forEach var="rList" items="${cr.rList}">

				<tr>
					<form aciton="ctrl.jsp?action=upply" method="post">
					<td></td>
					<td>↳</td>
					<td>${rList.rid }</td>
					<td>${rList.rom }</td>
					<input type="hidden" name="rid" value="${rList.rid }">
					<input type="hidden" name="rom" value="${rList.rom }">
					<input type="hidden" name="cnum" value="${rList.cnum }">
					<td><input type="submit" value="수정·삭제"></td>
					</form>
				</tr>

			</c:forEach>
			<form action="ctrl.jsp?action=insertReply" method="post">
				<tr>
					<td></td>
					<td><input type="text" placeholder="댓글 입력" name="rom"></td>
					<td><input type="text" placeholder="작성자 입력" name="rid"></td>
					<input type="hidden" value="${cr.c.cNum }" name="cnum">
					<td><input type="submit" value="댓글입력"></td>
				</tr>
			</form>
		</c:forEach>
		<tr>
			<td><a href="ctrl.jsp?action=goMain&mcnt=${mcnt+1}">더보기&gt;&gt;</a>
			</td>
		</tr>


	</table>
</body>
</html>