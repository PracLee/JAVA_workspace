<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="model.post.PostVO"/>
<jsp:setProperty property="*" name="vo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스트 수정</title>
</head>
<body>
	<form action="control.jsp?action=updatePostDB" method="post">
		<table>
			<tr>
				<th>title</th>
				<td><input type="text" name="title" value="<%=vo.getTitle() %>"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><input type="text" name="content" value="<%=vo.getContent() %>"></td>
			</tr>
		</table>
		<input type="hidden" value="<%=vo.getPostNum() %>" name="PostNum">
		<input type="hidden" value="<%=vo.getPostDate() %>" name="PostDate">
		<input type="submit" value="업데이트!">
	</form>
	<form action="control.jsp?action=DeletePost" method="post">
		<input type="hidden" value="<%=vo.getPostNum() %>" name="PostNum">
		<input type="submit" value="글 삭제하기">
	</form>
</body>
</html>