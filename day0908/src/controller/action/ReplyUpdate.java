package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReplyDAO;
import model.ReplyVO;

public class ReplyUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		ReplyVO RVO = new ReplyVO();
		ReplyDAO RDAO = new ReplyDAO();
		RVO.setRnum(Integer.parseInt(request.getParameter("rnum")));
    	RVO.setRom(request.getParameter("rom"));
    	RDAO.update(RVO);
    	forward.setPath("main.do");
    	forward.setRedirect(false);
		return forward;
	}

}
