<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="RVO" class="model.ReplyVO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글수정</title>
</head>
<body>
	<form method="post" action="ctrl.jsp?action=reupdate">
		<table>
			<tr>
				<td><input type="text" name="rom" placeholder="${rom }"></td>
				<input type="hidden" value="${rnum }" name="rnum">
				<input type="hidden" name="mcnt" value="${mcnt }">
				<td><input type="submit" value="내용 수정!"></td>
			</tr>
		</table>
	</form>
	<hr>
	<form action="ctrl.jsp?action=redelete" method="post">
		<input type="hidden" value="${rnum }" name="rnum"> <input
			type="hidden" name="mcnt" value="${mcnt }"> <input
			type="submit" value="댓글 삭제!">
	</form>
</body>
</html>