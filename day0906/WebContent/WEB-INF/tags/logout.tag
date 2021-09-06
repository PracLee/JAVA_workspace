<%@ tag language="java" pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("ID") != null) {
%>
<a href="insertPost.jsp">글쓰기</a>
<a href="control.jsp?action=mypage">마이페이지</a>
<a href="control.jsp?action=logout">로그아웃</a>
<%
	}
%>