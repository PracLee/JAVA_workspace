<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<form action="control.jsp?action=joinUs" method="post">
		<table>
			<tr>
				<th colspan="2">회원가입</th>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="ID"></td>
				<td><input type="button" value="중복체크"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="PW"></td>
			</tr>
			<tr>
				<td>PW 확인</td>
				<td><input type="password" name="PWPW"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="제출하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>