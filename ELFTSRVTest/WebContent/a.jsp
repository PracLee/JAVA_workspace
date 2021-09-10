<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="b.jsp" method="post">
		<table>
			<tr>
				<td><select name="data">
						<c:forEach var="v" items="${coffee }">
							<option>${v }</option>
						</c:forEach>
				</select></td>
				<td><input type="submit" value="선택하기!"></td>
			</tr>
		</table>
	</form>
</body>
</html>