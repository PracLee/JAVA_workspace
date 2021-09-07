<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포폴에 많이 나오긴하는데 필수는 아님</title>
</head>
<body>
	<form>
		<select name="test">
			<option>-</option>
			<option ${param.test=='a'?'selected':'' }>a</option>
			<option ${param.test=='b'?'selected':'' }>b</option>
			<option ${param.test=='c'?'selected':'' }>c</option>
		</select> <input type="submit" value="선택완료">
	</form>
	[${param.test }]를 선택했습니다.
	<!-- else를 지원하지 않으니, swich문 지원! -->
	<c:choose>
		<c:when test="${param.test=='a' }">
	A를 선택했습니다.
	</c:when>
		<c:when test="${param.test=='b' }">
	B를 선택했습니다.
	</c:when>
		<c:otherwise>
			<!-- default처럼 사용 -->
	C를 선택했습니다.
	</c:otherwise>
	</c:choose>
</body>
</html>