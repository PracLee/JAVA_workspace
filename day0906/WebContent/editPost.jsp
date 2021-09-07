<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스트 수정</title>
</head>
<body>
	<form action="control.jsp" method="post">
	<input type="hidden" name="action" value="PostUDB">
		<table>
			<tr>
				<th>title</th>
				<td><input type="text" name="title" value="${PVO.getTitle() }"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><input type="text" name="content" value="${PVO.getContent() }"></td>
			</tr>
		</table>
		<input type="hidden" value="${PVO.getPostNum() }" name="PostNum">
		<input type="hidden" value="${PVO.getPostDate() }" name="PostDate">
		<input type="submit" value="업데이트!">
	</form>
	<form action="control.jsp?action=DeletePost" method="post">
		<input type="hidden" value="${PVO.getPostNum() }" name="PostNum">
		<input type="submit" value="글 삭제하기">
	</form>
</body>
</html>