<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, model.kakao.KakaoVO, model.sinhan.SinhanVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="KVO" class="model.kakao.KakaoVO" />
<jsp:useBean id="KDAO" class="model.kakao.KakaoDAO" />
<jsp:useBean id="SVO" class="model.sinhan.SinhanVO" />
<jsp:useBean id="SDAO" class="model.sinhan.SinhanDAO" />
<%
	String action = request.getParameter("action");
	if (action.equals("main")) {
		request.setAttribute("Kdatas", KDAO.selectAll());
		request.setAttribute("Sdatas", SDAO.selectAll());
		pageContext.forward("main.jsp");
	} else if (action.equals("transfer")) {
		SVO.setAccount(Integer.parseInt(request.getParameter("account")));
		SVO.setBalance(Integer.parseInt(request.getParameter("balance")));
		SVO.setName(request.getParameter("name"));
		session.setAttribute("frombank",request.getParameter("frombank"));
		session.setAttribute("VO", SVO);
		request.setAttribute("Kdatas", KDAO.selectAll());
		request.setAttribute("Sdatas", SDAO.selectAll());
		pageContext.forward("transfer.jsp");
	} else if (action.equals("update")) { // SVO가 주고 KVO가 받고
		SVO = (SinhanVO)session.getAttribute("VO");
		KVO.setAccount(Integer.parseInt(request.getParameter("account")));
		KVO.setBalance(Integer.parseInt(request.getParameter("balance")));
		KVO.setName(request.getParameter("name"));
		int money = Integer.parseInt(request.getParameter("money"));
		String frombank = (String)session.getAttribute("frombank");
		String tobank = request.getParameter("tobank");
		System.out.println("from bank : "+frombank);
		System.out.println("to bank : "+tobank);
		if(SDAO.transfer(SVO, KVO, money, frombank, tobank)){
			session.invalidate();
			out.println("<script>alert('이체성공!');");
			out.println("document.location.href='index.jsp';</script>");
		}else{
			session.invalidate();
			out.println("<script>alert('이체실패ㅠㅠ');");
			out.println("document.location.href='index.jsp';</script>");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러!</title>
</head>
<body>

</body>
</html>