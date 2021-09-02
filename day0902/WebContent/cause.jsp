<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="res.jsp" method="post">
		<jsp:useBean id="PVO" class="model.ProductVO" scope="session" />
		<select name="product">
			<%
				String productList[] = PVO.getProductList();
				for (int i = 0; i < productList.length; i++) {
			%>
			<option><%=productList[i]%></option>
			<%
				}
			%>
		</select> <input type="number" name="many" placeholder="개수를입력해주세요!"> <input
			type="submit" value="구매하기!">

	</form>
</body>
</html>