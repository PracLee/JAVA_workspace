<%@ tag language="java" pageEncoding="UTF-8"%>


<%
		if (session.getAttribute("ID")==null) {
	%>
<form name="login" action="control.jsp?action=login" method="post">
	<table>
		<tr>
			<th colspan="2">Login</th>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID" placeholder="ID를 입력해주세요"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="PW" placeholder="PW를 입력해주세요"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="login"></td>
		</tr>
	</table>
</form>
<a href="joinUs.jsp">회원가입</a>
<%
		}
	%>