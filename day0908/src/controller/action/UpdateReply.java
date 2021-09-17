package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateReply implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
    	request.setAttribute("rnum", request.getParameter("rnum"));
    	request.setAttribute("rom", request.getParameter("rom"));
    	forward.setPath("reEdit.jsp");
		forward.setRedirect(false);
    	return forward;
	}
}
