<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
</head>
<body>
	<table>
		<%
			System.out.println("mypage도착");
			for (PostVO vo : (ArrayList<PostVO>) datas) {
		%>
		<tr>
			<td><%=vo.getPostNum()%></td>
			<td><%=vo.getPostDate()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getContent()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>