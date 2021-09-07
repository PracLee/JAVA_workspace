<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action ="control.jsp?action=JoinUS" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="PW"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="가입하기"></td>
		</tr>

	</table>
	</form>
</body>
</html>