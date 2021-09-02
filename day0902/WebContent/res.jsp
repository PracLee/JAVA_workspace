<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구매하신 물품은 ${param.product }이고, ${param.many }개 구매하셧습니다.</h2>
	<h2>총가격은 ${param.many*PVO.printPrice(param.product) }원 입니다.</h2>
</body>
</html>