<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.board.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	BoardDAO dao = new BoardDAO();
	BoardVO data = new BoardVO();
	data = dao.getBoard(data);
	request.setAttribute("data", data);
%>
<body>
	<form action="updateAction.jsp" method="post">
		<input type="hidden" name="id" value="${data.id}">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${data.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="${data.content}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성하기"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="deleteBoard.jsp">글 삭제</a>
	<a href="main.jsp">메인으로 돌아가기</a>
</body>
</html>