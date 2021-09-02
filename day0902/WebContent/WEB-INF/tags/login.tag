<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%
	if (session.getAttribute("ID")==null) { // 로그인이 안됬을때
%>
<form action="ctrl.jsp">
	<table border="1">
		<tr>
			<th>로그인!</th>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="PW"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="login"></td>
		</tr>
	</table>
</form>
<%
	} else {
%>
<form action="ctrl.jsp">
	<input type="submit" value="로그아웃">
</form>
<%
	}
%>