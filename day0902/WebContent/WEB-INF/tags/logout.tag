<%@ tag language="java" pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("ID") != null) { // 로그인이 안됬을때
%>
<form action="ctrl.jsp">
	<input type="submit" value="로그아웃">
</form>
<%
	}
%>