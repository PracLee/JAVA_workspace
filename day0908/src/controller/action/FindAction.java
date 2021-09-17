package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;

public class FindAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		CommentVO CVO = new CommentVO();
		CommentDAO CDAO = new CommentDAO();
    	CVO.setID(request.getParameter("ID"));
    	request.setAttribute("datas", CDAO.selectOne(CVO));
    	request.setAttribute("ID", CVO.getID());
    	
    	forward.setPath("findList.jsp");
    	forward.setRedirect(false);
		return forward;
	}

}
