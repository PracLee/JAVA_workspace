<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.*" %>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="CVO" class="model.CommentVO"/>
    <jsp:useBean id="CDAO" class="model.CommentDAO"/>
    <jsp:useBean id="RVO" class="model.ReplyVO"/>
    <jsp:useBean id="RDAO" class="model.ReplyDAO"/>
    <jsp:useBean id="CR" class="model.CommentReply"/>
    <%
    String action = request.getParameter("action");
    
    if (action.equals("goMain")){
    	ArrayList<CommentReply> datas = new ArrayList<CommentReply>();
    	ArrayList<CommentVO> Cdata = CDAO.selectAll();
    	for(int i=0;i<Cdata.size();i++){
    		ArrayList<ReplyVO> Rdata = RDAO.selectAll(Cdata.get(i).getcNum());	// 댓글 개수 가져오기
			CommentReply cr = new CommentReply();
    		cr.setC(Cdata.get(i));
    		cr.setrList(Rdata);
    		datas.add(cr);
    	}
    	request.setAttribute("datas", datas);
    	pageContext.forward("DBCP.jsp");
    }else if(action.equals("insert")){
    	CVO.setCom(request.getParameter("com"));
    	CVO.setID(request.getParameter("ID"));
    	CVO.setPW(request.getParameter("PW"));
    	CDAO.insert(CVO);
    	pageContext.forward("index.jsp");
    }else if (action.equals("IDPWcheck")){
    	System.out.println("PW : "+request.getParameter("PW"));
    	System.out.println("Pcheck : "+request.getParameter("PWcheck"));
    	if(request.getParameter("PWcheck").equals(request.getParameter("PW"))){
        	request.setAttribute("PW", request.getParameter("PW"));
        	request.setAttribute("com", request.getParameter("com"));
        	request.setAttribute("cNum", request.getParameter("cNum"));	
        	pageContext.forward("edit.jsp");
    	}else{
			out.println("<script>alert('비밀번호가 일치하지 않습니다!')");
			out.println("document.location.href='index.jsp'</script>");
    	}
    }else if (action.equals("update")){
    	CVO.setcNum(Integer.parseInt(request.getParameter("cNum")));
    	CVO.setCom(request.getParameter("com"));
    	CDAO.update(CVO);
    	pageContext.forward("index.jsp");
    }else if (action.equals("delete")){
    	CVO.setcNum(Integer.parseInt(request.getParameter("cNum")));
    	CDAO.delete(CVO);
    	pageContext.forward("index.jsp");
    }else if(action.equals("find")){
    	CVO.setID(request.getParameter("ID"));
    	request.setAttribute("datas", CDAO.selectOne(CVO));
    	request.setAttribute("ID", CVO.getID());
    	pageContext.forward("findList.jsp");
    }else if(action.equals("insertReply")){
    	RVO.setRid(request.getParameter("rid"));
    	RVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
    	RVO.setRom(request.getParameter("rom"));
    	RDAO.insert(RVO);
    	pageContext.forward("index.jsp");
    }else if(action.equals("updateReply")){
    	RVO.setRid(request.getParameter("rid"));
    	RVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
    	RVO.setRom(request.getParameter("rom"));
    	RVO = RDAO.selectOne(RVO);
    	request.setAttribute("RVO", RVO);
    	pageContext.forward("reEdit.jsp");
    }else if (action.equals("reupdate")){
    	RVO.setRnum(Integer.parseInt(request.getParameter("rnum")));
    	RVO.setRom(request.getParameter("rom"));
    	RDAO.update(RVO);
    	pageContext.forward("index.jsp");
    }else if (action.equals("redelete")){
    	CVO.setcNum(Integer.parseInt(request.getParameter("rnum")));
    	RDAO.delete(RVO);
    	pageContext.forward("index.jsp");
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