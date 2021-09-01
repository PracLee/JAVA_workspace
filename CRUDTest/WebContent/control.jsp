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
	} else if (action.equals("view")) { // 글 내용보기

	} else if (action.equals("post")) {
		PVO.setId((String)session.getAttribute("ID"));
		PVO.setTitle(request.getParameter("title"));
		PVO.setContent(request.getParameter("content"));
		if(PDAO.postPost(PVO)){
			response.sendRedirect("index.jsp");
		}else{
			out.println("글작성중 오류발생!");
		}
	} else if (action.equals("login")) {
		UVO.setID(request.getParameter("ID"));
		UVO.setPW(request.getParameter("PW"));
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
		for(PostVO vo : datas){
			System.out.println(vo);
		}
		request.setAttribute("datas", datas);
		pageContext.forward("template_list.jsp");
	}
%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Controller</title>

</html>