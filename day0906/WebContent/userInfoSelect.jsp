<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원하시는 메뉴를 선택해주세요!</title>
</head>
<body>
	<p>원하시는 메뉴를 선택해주세요!</p>
	<form action="control.jsp?action=update" method="post">
		<p>비밀번호 변경을 원하시면 비밀번호를 입력후에 회원정보 변경을 눌러주세요!</p>
		<input type="password" name="PW" placeholder="새로운 비밀번호 입력!"> <input
			type="submit" value="회원정보변경">
	</form>
	<form action="control.jsp?action=delete" method="post">
		<p>회원탈퇴를 원하시면 여기를 눌러주세요!</p>
		<input type="submit" value="회원탈퇴">
	</form>
</body>
</html>