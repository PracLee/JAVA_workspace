<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, model.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ad" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP실습!</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>로그인 안하고 댓글남기는 컨셉</h1>
	<ad:ad ad02_src="img/ad02.jpg" ad03_href="#"
		ad02_href="http://item.gmarket.co.kr/Item?goodscode=1566592119"
		ad01_href="#" ad01_src="img/ad01.jpg" ad03_src="img/ad03.jpg" />
	<form method="post" action="ctrl.jsp?action=insert">
		<table>
			<tr>
				<td><input type="text" name="com" placeholder="내용입력(300자까지)">
				</td>
				<td><input type="text" name="ID" placeholder="ID입력"></td>
				<td><input type="password" name="PW" placeholder="PW입력">
				</td>
				<td><input type="submit" value="댓글입력하기!"></td>
				<input type="hidden" name="mcnt" value="${mcnt }">
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
			<th>댓글수</th>
			<th>좋아요</th>
			<th>좋아요 수</th>
		</tr>
		<c:forEach var="cr" items="${datas }">
			<form action="ctrl.jsp?action=IDPWcheck" method="post">
				<tr>
					<th>${cr.c.cNum }</th>
					<th>${cr.c.com }</th>
					<th>${cr.c.ID }</th>
					<td><input type="password"
						placeholder="수정·삭제하려면 비밀번호를 입력해주세요!" name="PWcheck"></td>
					<td><input type="submit" value="수정·삭제"></td>
					<td>${cr.c.replyCnt}</td>
					<td><a href="ctrl.jsp?action=likeUp&cNum=${cr.c.cNum }" id="like">❤</a></td>
					<td>${cr.c.likeCnt}</td>
					<input type="hidden" value="${cr.c.cNum }" name="cNum">
					<input type="hidden" value="${cr.c.com }" name="com">
					<input type="hidden" value="${cr.c.PW }" name="PW">
					<input type="hidden" name="mcnt" value="${mcnt }">
				</tr>
			</form>
			<c:forEach var="rList" items="${cr.rList}">
				<form action="ctrl.jsp?action=upply" method="post">
					<tr>
						<td></td>
						<td>↳</td>
						<td>${rList.rid }</td>
						<td>${rList.rom }</td>
						<input type="hidden" name="rnum" value="${rList.rnum }">
						<input type="hidden" name="rid" value="${rList.rid }">
						<input type="hidden" name="rom" value="${rList.rom }">
						<input type="hidden" name="cnum" value="${rList.cnum }">
						<input type="hidden" name="mcnt" value="${mcnt }">
						<td><input type="submit" value="수정·삭제"></td>
					</tr>
				</form>
			</c:forEach>
			<form action="ctrl.jsp?action=insertReply" method="post">
				<tr>
					<td></td>
					<td><input type="text" placeholder="댓글 입력" name="rom"></td>
					<td><input type="text" placeholder="작성자 입력" name="rid"></td>
					<input type="hidden" value="${cr.c.cNum }" name="cnum">
					<input type="hidden" name="mcnt" value="${mcnt }">
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