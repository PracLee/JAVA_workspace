<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.member.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPw(pw);
	MemberDAO dao = new MemberDAO();
	MemberVO data = dao.getOne(vo);
	if(data!=null){
		response.sendRedirect("main.jsp");
	}else{
		response.sendRedirect("index.jsp");
	}
%>