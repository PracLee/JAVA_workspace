<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="NewFile.jsp">
		<jsp:useBean id="dataBean" class="model.DataBean" scope="session" />
		<select name="data">
			<%
				for (String v : dataBean.getDataList()) {
			%>
			<option><%=v %></option>
			<%
				}
			%>
		</select>
		<input type="submit" value="다음페이지로!">
	</form>



</body>
</html>