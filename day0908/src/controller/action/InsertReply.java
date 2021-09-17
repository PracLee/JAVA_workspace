package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;
import model.ReplyDAO;
import model.ReplyVO;

public class InsertReply implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		ReplyVO RVO = new ReplyVO();
		ReplyDAO RDAO = new ReplyDAO();
		CommentVO CVO = new CommentVO();
		CommentDAO CDAO = new CommentDAO();
    	RVO.setRid(request.getParameter("rid"));
    	RVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
    	RVO.setRom(request.getParameter("rom"));
    	RDAO.insert(RVO);
    	CVO.setcNum(RVO.getCnum());
    	CDAO.insert(CVO);
    	forward.setPath("main.do");
    	forward.setRedirect(false);
		return forward;
	}
	
}
