package tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.post.PostDAO;
import model.post.PostVO;

public class ShowListTag extends SimpleTagSupport {
	public void doTag() throws IOException, JspException {

		JspWriter out = getJspContext().getOut();
		PostVO PVO = new PostVO();
		PostDAO PDAO = new PostDAO();
		ArrayList<PostVO> datas = PDAO.showPostList();
		JspFragment body = getJspBody();	//jsp에 body를 가져오는 객체
		if(body!=null) {	// 만약에 태그 바디가 있다면
			out.println("<h1>");
			body.invoke(null);	// 바디 태그 안에 다시 넣기
			out.println("</h1>");
		}
		for(int i =0;i<datas.size();i++) {
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
	}
}


