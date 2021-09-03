<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pay"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pay:pay product="${param.product }" many="${param.many }" color="red" fontSize="66px" >메세지를 넣었다</pay:pay>
</body>
</html>