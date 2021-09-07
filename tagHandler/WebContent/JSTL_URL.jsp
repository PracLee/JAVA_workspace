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

<c:url value="JSTL_choose_when.jsp" var="testURL">
	<c:param name="test">b</c:param>
</c:url>
<h2>${testURL }</h2>
<a href="${testURL }">눌러보시죠</a>
<!-- 
해당되는 URL에 param의 바디태그에 값을 넣어서 줄 수 있다.
 -->
</body>
</html>