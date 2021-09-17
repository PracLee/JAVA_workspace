package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;

public class UpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		CommentVO CVO = new CommentVO();
		CommentDAO CDAO = new CommentDAO();
		CVO.setcNum(Integer.parseInt(request.getParameter("cNum")));
    	CVO.setCom(request.getParameter("com"));
    	CDAO.update(CVO, "update");
    	forward.setPath("/main.do");
		forward.setRedirect(false);
		return forward;
	}

}
