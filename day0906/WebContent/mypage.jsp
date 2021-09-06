<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<%@ taglib tagdir="/WEB-INF/tags" prefix="log"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>
	<p>
		고객님의 ID는
		<%=session.getAttribute("ID")%>
		이고,PW는
		<%=session.getAttribute("PW")%>
		입니다.
	</p>
	<p>고객님이 쓴 글 정보입니다.</p>
	<form action ="control.jsp" method="post">
	<input type="hidden" name="action" value ="updateP" >
	<table>
		<%
		System.out.println("mypage도착");
		for (PostVO vo : (ArrayList<PostVO>) datas) {
	%>
		<tr>
			<td><%= vo.getPostNum() %></td>
			<td><%= vo.getPostDate() %></td>
			<td><%= vo.getTitle() %></td>
			<td><%= vo.getContent() %></td>
			<td><input type="submit" value="수정하기"></td>
			<input type="hidden" value ="<%=vo.getPostNum() %>" name="PostNum">
			<input type="hidden" value ="<%=vo.getPostDate() %>" name="PostDate">
			<input type="hidden" value ="<%=vo.getTitle() %>" name="title">
			<input type="hidden" value ="<%=vo.getContent() %>" name="content">
		</tr>
		<%
		System.out.println(vo+"for문 도는 VO");
		}
	%>
	</table>
	</form>
	<p>회원정보를 변경·삭제하시려면 비밀번호를 입력해주세요!</p>
	<form action="control.jsp?action=checkInfo" method="post">
		<input type="text" placeholder="회원정보를 변경·삭제하시려면 비밀번호를 입력해주세요!"
			name="PW"> <input type="submit" value="회원 정보 변경·탈퇴">
	</form>
</body>
</html>