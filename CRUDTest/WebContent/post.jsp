<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<form action="control.jsp?action=post" method="post">
<table>
<tr><td>제목</td><td><input type="text" placeholder="제목을 입력해주세요" name="title"></td></tr>
<tr><td>내용</td><td><input type="textarea" placeholder="내용을 입력해주세요" name="content"></td></tr>
<tr><td><input type="submit" value="등록하기"></td></tr>
</table>
</form>
</body>
</html>