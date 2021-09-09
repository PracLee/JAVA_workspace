<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체페이지</title>
</head>
<body>
	<table>
		<tr>
			<th>신한은행 계좌 목록</th>
		</tr>
		<tr>
			<td>계좌번호</td>
			<td>이름</td>
			<td>잔액</td>
		</tr>
		<c:forEach var="Sv" items="${Sdatas }">
			<form action="ctrl.jsp?action=update" method="post">
				<tr>
					<td>${Sv.account }</td>
					<td>${Sv.name }</td>
					<td>${Sv.balance }</td>
					<td><input type="number" name="money" placeholder="이체금액입력"></td>
					<td><input type="submit" value="원을 이체합니다"></td>
					<input type="hidden" value="sinhan" name="tobank">
					<input type="hidden" value="${Sv.account }" name="account">
					<input type="hidden" value="${Sv.name }" name="name">
					<input type="hidden" value="${Sv.balance }" name="balance">
				</tr>
			</form>
		</c:forEach>
	</table>
	<table>
		<tr>
			<th>카카오뱅크 계좌 목록</th>
		</tr>
		<tr>
			<td>계좌번호</td>
			<td>이름</td>
			<td>잔액</td>
		</tr>
		<c:forEach var="Kv" items="${Kdatas }">
			<form action="ctrl.jsp?action=update" method="post">
				<tr>
					<td>${Kv.account }</td>
					<td>${Kv.name }</td>
					<td>${Kv.balance }</td>
					<td><input type="number" name="money" placeholder="이체금액입력"></td>
					<td><input type="submit" value="원을 이체합니다"></td>
					<input type="hidden" value="kakao" name="tobank">
					<input type="hidden" value="${Kv.account }" name="account">
					<input type="hidden" value="${Kv.name }" name="name">
					<input type="hidden" value="${Kv.balance }" name="balance">
				</tr>
			</form>
		</c:forEach>
	</table>
	<hr>
	<table>
		<tr>
			<th>보낼 계좌</th>
		</tr>
		<tr>
			<td>계좌번호</td>
			<td>이름</td>
			<td>잔액</td>
		</tr>
		<tr>
			<td>${VO.account }</td>
			<td>${VO.name }</td>
			<td>${VO.balance }</td>
		</tr>
	</table>
</body>
</html>