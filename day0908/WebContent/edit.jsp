<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<form method="post" action="update.do">
		<table>
			<tr>
				<td><input type="text" name="com" value="${com }"></td>
				<input type="hidden" name="mcnt" value="${mcnt }">
				<input type="hidden" value="${cNum }" name="cNum">
				<td><input type="submit" value="내용 수정!"></td>
			</tr>
		</table>
	</form>
	<hr>
	<form action="delete.do" method="post">
		<input type="hidden" value="${cNum }" name="cNum"> <input
			type="hidden" name="mcnt" value="${mcnt }"> <input
			type="submit" value="댓글 삭제!">
	</form>
</body>
</html>