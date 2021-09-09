<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, model.kakao.KakaoVO, model.sinhan.SinhanVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 현황!</title>
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
			<form action="ctrl.jsp?action=transfer" method="post">
				<tr>
					<td>${Sv.account }</td>
					<td>${Sv.name }</td>
					<td>${Sv.balance }</td>
					<td><input type="submit" value="이 계좌 이체"></td>
					<input type="hidden" value="sinhan" name="frombank">
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
			<form action="ctrl.jsp?action=transfer" method="post">
				<tr>
					<td>${Kv.account }</td>
					<td>${Kv.name }</td>
					<td>${Kv.balance }</td>
					<td><input type="submit" value="이 계좌 이체"></td>
					<input type="hidden" value="kakao" name="frombank">
					<input type="hidden" value="${Kv.account }" name="account">
					<input type="hidden" value="${Kv.name }" name="name">
					<input type="hidden" value="${Kv.balance }" name="balance">
				</tr>
			</form>
		</c:forEach>
	</table>

</body>
</html>