package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;
import model.ReplyDAO;

public class DeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		CommentVO CVO = new CommentVO();
		CommentDAO CDAO = new CommentDAO();
		ReplyDAO RDAO = new ReplyDAO();
		CVO.setcNum(Integer.parseInt(request.getParameter("cNum")));
    	RDAO.deleteComment(CVO);
    	CDAO.delete(CVO);
    	forward.setPath("main.do");
		forward.setRedirect(false);
		return forward;
	}

}
