<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<%@ taglib tagdir="/WEB-INF/tags" prefix="log"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
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
	<form action="control.jsp?action=find" method="post">
		<input type="text" name="index"> <input type="submit"
			value="검색">
	</form>
	<log:login/>
	<log:logout/>

</body>
</html>