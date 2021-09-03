<%@ tag language="java" pageEncoding="UTF-8"%>


<%
		if (session.getAttribute("ID")==null) {
	%>
<a href="login.jsp">로그인</a>
<a href="joinUs.jsp">회원가입</a>
<%
		}
	%>