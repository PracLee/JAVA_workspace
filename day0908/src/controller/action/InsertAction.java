package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;

public class InsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		CommentVO CVO = new CommentVO();
		CommentDAO CDAO = new CommentDAO();
		CVO.setCom(request.getParameter("com"));
    	CVO.setID(request.getParameter("ID"));
    	CVO.setPW(request.getParameter("PW"));
    	CDAO.insert(CVO);
    	forward.setPath("main.do");
    	forward.setRedirect(false);
		return forward;
	}

}
