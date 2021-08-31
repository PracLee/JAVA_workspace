<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, model.userInfo.*, model.post.*"%>
<jsp:useBean id="UVO" class="model.userInfo.UserVO" />
<jsp:useBean id="UDAO" class="model.userInfo.UserDAO" />
<jsp:useBean id="PVO" class="model.post.PostVO" />
<jsp:useBean id="PDAO" class="model.post.PostDAO" />
<jsp:setProperty property="*" name="PVO" />
<jsp:setProperty property="*" name="UVO" />
<%
    String action = request.getParameter("action");
	if(action.equals("list")){	// 글 목록보내기
		ArrayList<PostVO> datas = PDAO.showlist();
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp");
	}else if(action.equals("view")){	// 글 내용보기
		
	}else if(action.equals("post")){
		
	}else if(action.equals("login")){
		UVO.setID(request.getParameter("ID"));
		UVO.setPW(request.getParameter("PW"));
		if(UDAO.loginCheck(UVO)){
			session.setAttribute("ID", UVO.getID());
			session.setAttribute("PW", UVO.getPW());
			System.out.println(session.getAttribute("ID"));
			response.sendRedirect("index.jsp");
		}else{
			System.out.println(session.getAttribute("ID"));
			out.println("<script>alert('로그인 실패!')");
			out.println("document.location.href='login.jsp'</script>");
		}
	}
    %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Controller</title>

</html>