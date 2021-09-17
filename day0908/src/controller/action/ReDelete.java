package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;
import model.ReplyDAO;
import model.ReplyVO;

public class ReDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(1);
		ActionForward forward = new ActionForward();
		ReplyVO RVO = new ReplyVO();
		ReplyDAO RDAO = new ReplyDAO();
		RVO.setRnum(Integer.parseInt(request.getParameter("rnum")));
		RDAO.delete(RVO);
		System.out.println(2);
		CommentVO CVO = new CommentVO();
		System.out.println(3);
		CommentDAO CDAO = new CommentDAO();
		CVO.setcNum(Integer.parseInt(request.getParameter("cnum")));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+CVO.getcNum());
		CDAO.update(CVO, "LikeDown");
		forward.setPath("main.do");
		forward.setRedirect(false);
		return forward;
	}

}
