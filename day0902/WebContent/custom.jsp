<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Tag</title>
</head>
<body>

	<h1>
		<mytag:PrintTag />
	</h1>
	<h6>
		<mytag:PrintTag />
	</h6>
	<mytag:printDataBean border="1" bgcolor="pink">실습중입니다.</mytag:printDataBean>
</body>
</html>