<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.board.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%
	BoardDAO dao = new BoardDAO();
	List<BoardVO> datas = dao.getBoardList("");
%> --%>
<body>
	<h1>글 목록</h1>
	<hr>
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${datas }" var="v">
			<tr>
				<td>${v.id}</td>
				<td><a href="showBoard.jsp?id=${v.id}">${v.title}</a></td>
				<td>${v.writer}</td>
			</tr>
		</c:forEach>
	</table>
<hr>
<a href="insertBoard.jsp">글 작성</a>
<a href="logout.jsp">로그아웃</a>

</body>
</html>