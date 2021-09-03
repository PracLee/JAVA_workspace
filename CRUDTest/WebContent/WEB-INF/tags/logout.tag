<%@ tag language="java" pageEncoding="UTF-8"%>

<%
if (session.getAttribute("ID")!=null) { 
	%>
<a href="post.jsp">글쓰기</a>
<a href="control.jsp?action=mypage">내가 쓴 글 보기</a>
<a href="control.jsp?action=logout">로그아웃</a>
<%
		}
	%>