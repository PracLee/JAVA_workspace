<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertAction.jsp" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>