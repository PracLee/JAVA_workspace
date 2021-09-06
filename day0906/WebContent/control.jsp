<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="java.util.ArrayList, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="PVO" class="model.post.PostVO" />
<jsp:useBean id="PDAO" class="model.post.PostDAO" />
<jsp:useBean id="UVO" class="model.user.UserVO" />
<jsp:useBean id="UDAO" class="model.user.UserDAO" />
<jsp:setProperty property="*" name="PVO" />
<jsp:setProperty property="*" name="UVO" />


<%
	String action = request.getParameter("action");
	if (action.equals("main")) {
		pageContext.forward("main.jsp");
	} else if (action.equals("login")) {
		UVO.setID(request.getParameter("ID"));
		UVO.setPW(request.getParameter("PW"));
		System.out.println("로그인 들어왔다");
		if (UDAO.selectOne(UVO)) {
			session.setAttribute("ID", UVO.getID());
			session.setAttribute("PW", UVO.getPW());
			pageContext.forward("index.jsp"); //mypage로 가는 조건 만들어야함
		} else {
			out.println("<script>alert('회원정보가 일치하지 않습니다!')");
			out.println("document.location.href='main.jsp'</script>");
		}
	} else if (action.equals("checkInfo")) {
		UVO.setID((String) session.getAttribute("ID"));
		String PW = (String) session.getAttribute("PW");
		if (PW.equals(request.getParameter("PW"))) {
			UVO.setPW(PW);
			pageContext.forward("userInfoSelect.jsp");
		} else {
			out.println("<script>alert('회원정보가 일치하지 않습니다!')");
			out.println("document.location.href='mypage.jsp'</script>");
		}
	} else if (action.equals("update")) {
		UVO.setID((String) session.getAttribute("ID"));
		UVO.setPW(request.getParameter("PW"));
		UDAO.update(UVO);
		pageContext.forward("index.jsp");
	} else if (action.equals("logout")) {
		session.invalidate();
		pageContext.forward("index.jsp");
	}else if(action.equals("mypage")){
		String ID = (String)session.getAttribute("ID");	
		String PW = (String)session.getAttribute("PW");	
		PVO.setID((String) session.getAttribute("ID"));
		ArrayList<PostVO> datas = PDAO.whoWriter(PVO);
		request.setAttribute("datas", datas);
		pageContext.forward("mypage.jsp");
	}
	else if (action.equals("delete")) {
		UVO.setID((String) session.getAttribute("ID"));
		UDAO.delete(UVO);
		pageContext.forward("index.jsp");

		// post DAO시작
	} else if (action.equals("insertPost")) {
		PVO.setTitle(request.getParameter("title"));
		PVO.setContent(request.getParameter("content"));
		PVO.setID((String) session.getAttribute("ID"));
		System.out.println(PVO);
		PDAO.insertPost(PVO);
		pageContext.forward("index.jsp");
	} else if (action.equals("deletePost")) {
		PVO.setPostNum(Integer.parseInt(request.getParameter("postNum")));
		PDAO.deletePost(PVO);
		pageContext.forward("index.jsp");
	} else if (action.equals("updatePost")) {
		PVO.setTitle(request.getParameter("title"));
		PVO.setContent(request.getParameter("content"));
		PVO.setID((String) session.getAttribute("ID"));
		PDAO.updatePost(PVO);
		pageContext.forward("index.jsp");
	} else if (action.equals("updatePost")) {
		System.out.println("컨트롤러 도착");
		PVO.setContent(request.getParameter("content"));
		PVO.setID((String)session.getAttribute("ID"));
		PVO.setPostDate(request.getParameter("PostDate"));
		PVO.setPostNum(Integer.parseInt(request.getParameter("PostNum")));
		PVO.setTitle(request.getParameter("title"));
		request.setAttribute("PVO", PVO);
		System.out.println("edit로 간다");
		response.sendRedirect("editPost.jsp");
	} else if(action.equals("DeletePost")){
		PDAO.deletePost(PVO);
		pageContext.forward("index.jsp");
	} else if(action.equals("updatePostDB")){
		PDAO.updatePost(PVO);
		pageContext.forward("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>controller</title>
</head>
<body>

</body>
</html>