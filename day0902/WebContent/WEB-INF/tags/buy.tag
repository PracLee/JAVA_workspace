<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<form action="pay.jsp" method="post">
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