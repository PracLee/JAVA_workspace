<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로운 포스트 작성</title>
</head>
<body>
	<form action="control.jsp?action=insertPost" method="post">
		<table>
			<tr>
				<th>title</th>
				<td><input type="text" name="title" placeholder="제목을 입력해주세요"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><input type="text" name="content" placeholder="내용을 입력해주세요"></td>
			</tr>
		</table>
		<input type="submit" value="게시하기!">
	</form>
</body>
</html>