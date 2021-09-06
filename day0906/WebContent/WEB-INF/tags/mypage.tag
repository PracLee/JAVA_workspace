<%@ tag language="java" pageEncoding="UTF-8" import ="java.util.ArrayList, model.post.*"%>

	<p>
		고객님의 ID는
		<%=session.getAttribute("ID")%>
		이고,PW는
		<%=session.getAttribute("PW")%>
		입니다.
	</p>
	<p>고객님이 쓴 글 정보입니다.</p>
	<%
	ArrayList<PostVO> datas = (ArrayList<PostVO>)request.getAttribute("datas");
	for(int i=0;i<datas.size();i++){
		out.println("<article class='col-12 col-md-6 tm-post'>");
		out.println("<hr class='tm-hr-primary'>");
		out.println("<a href='post.html' class='effect-lily tm-post-link tm-pt-60'>");
		out.println("<div class='tm-post-link-inner'>");
		out.println("<img src='img/img-01.jpg' alt='Image' class='img-fluid'></div> <span class='position-absolute tm-new-badge'>New</span>");
		out.println("<h2 class='tm-pt-30 tm-color-primary tm-post-title'>"+datas.get(i).getTitle()+"</h2></a>");
		out.println("<p class='tm-pt-30'>"+datas.get(i).getContent()+"</p>");
		out.println("<div class='d-flex justify-content-between tm-pt-45'><span class='tm-color-primary'>"+datas.get(i).getPostNum()+"</span> <span class='tm-color-primary'>");
		out.println(datas.get(i).getPostDate()+"</span></div><hr><div class='d-flex justify-content-between'>");
		out.println("<span>36 comments</span> <span>"+datas.get(i).getID()+"</span></div></article>");
	}
	%>
	<p>회원정보를 변경·삭제하시려면 비밀번호를 입력해주세요!</p>
	<form action="control.jsp?action=checkInfo" method="post">
		<input type="text" placeholder="회원정보를 변경·삭제하시려면 비밀번호를 입력해주세요!"
			name="PW"> <input type="submit" value="회원 정보 변경·탈퇴">
	</form>