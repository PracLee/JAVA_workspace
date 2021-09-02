<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, model.userInfo.*, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="UVO" class="model.userInfo.UserVO" />
<jsp:useBean id="UDAO" class="model.userInfo.UserDAO" />
<jsp:useBean id="PVO" class="model.post.PostVO" />
<jsp:useBean id="PDAO" class="model.post.PostDAO" />
<jsp:setProperty property="*" name="PVO" />
<jsp:setProperty property="*" name="UVO" />

<%
	String action = request.getParameter("action");
	if (action.equals("list")) { // 글 목록보내기
		ArrayList<PostVO> datas = PDAO.showlist();
		request.setAttribute("datas", datas);
		pageContext.forward("template_list.jsp");
	} else if (action.equals("post")) {
		PVO.setId((String) session.getAttribute("ID"));
		PVO.setTitle(request.getParameter("title"));
		PVO.setContent(request.getParameter("content"));
		if (PDAO.postPost(PVO)) {
			response.sendRedirect("index.jsp");
		} else {
			out.println("글작성중 오류발생!");
		}
	} else if (action.equals("login")) {
		if (UVO.getID().equals("")||UVO.getPW().equals("")) {
			UVO.setID(request.getParameter("ID"));
			UVO.setPW(request.getParameter("PW"));
		}
		if (UDAO.loginCheck(UVO)) {
			session.setAttribute("ID", UVO.getID());
			session.setAttribute("PW", UVO.getPW());
			System.out.println(session.getAttribute("ID"));
			response.sendRedirect("index.jsp");
		} else {
			System.out.println(session.getAttribute("ID"));
			out.println("<script>alert('로그인 실패!')");
			out.println("document.location.href='login.jsp'</script>");
		}
	} else if (action.equals("logout")) {
		session.invalidate();
		response.sendRedirect("index.jsp");
	} else if (action.equals("mypage")) {
		PVO.setId((String) session.getAttribute("ID"));
		ArrayList<PostVO> datas = PDAO.showMyList(PVO);
		request.setAttribute("datas", datas);
		pageContext.forward("mypage.jsp");
	} else if (action.equals("find")) {
		String index = request.getParameter("index");
		ArrayList<PostVO> datas = PDAO.findPost(index);
		for (PostVO vo : datas) {
			System.out.println(vo);
		}
		request.setAttribute("datas", datas);
		pageContext.forward("template_list.jsp");
	} else if (action.equals("joinUS")) { // 회원가입
		String ID = request.getParameter("ID");
		String PW = request.getParameter("PW");
		String PWPW = request.getParameter("PWPW");
		System.out.println("패스워드 체크 전");
		if (PW.equals(PWPW)) {
			UVO.setID(request.getParameter("ID"));
			UVO.setPW(PW);
			UDAO.JoinUs(UVO); //DB업데이트
			session.setAttribute("ID", ID);
			session.setAttribute("PW", PW);
			System.out.println("패스워드 체크 후");
			response.sendRedirect("index.jsp");
		}else{
			out.println("<script>alert('비밀번호가 일치하지 않습니다.');");
			out.println("document.location.href='joinus.jsp'</script>");
		}
	}
%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Controller</title>

</html>