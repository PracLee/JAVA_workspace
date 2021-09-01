<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글 보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%
			for (PostVO vo : (ArrayList<PostVO>) datas) {
		%>
		<tr>
			<td><%=vo.getPostnum()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getId()%></td>
			<td><%=vo.getPostdate()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>