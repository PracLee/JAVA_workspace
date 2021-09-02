<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="MB" class="model.MemberBean" />
<jsp:setProperty property="*" name="MB" />
<%
    String ID = request.getParameter("ID");
    String PW = request.getParameter("PW");
    if(MB.getID().equals(ID)&&MB.getPW().equals(PW)){
    	session.setAttribute("ID", MB.getID());
    	session.setAttribute("PW", MB.getPW());
        System.out.println("세션 만들어짐");
		response.sendRedirect("login.jsp");
    }else{	// 로그인시 초기화
    System.out.println("로그인시 초기화");
    session.invalidate();
	response.sendRedirect("login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>