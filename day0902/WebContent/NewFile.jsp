<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	선택한 데이터는 ${param.data} 입니다.
	<br> ${dataBean.data1 }
	<br> ${dataBean.data2 }
	<br> ${dataBean.data1 + dataBean.data2 }
	<br> ${dataBean.data1 gt dataBean.data2 }
	<br>
</body>
</html>