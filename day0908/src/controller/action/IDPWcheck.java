package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IDPWcheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		if(request.getParameter("PWcheck").equals(request.getParameter("PW"))){
        	request.setAttribute("PW", request.getParameter("PW"));
        	request.setAttribute("com", request.getParameter("com"));
        	request.setAttribute("cNum", request.getParameter("cNum"));	
        	forward.setPath("edit.jsp");
        	forward.setRedirect(false);
    	}else{
    		PrintWriter out=response.getWriter();
			out.println("<script>alert('비밀번호가 일치하지 않습니다!')");
			out.println("history.go(-1)</script>");
    	}
		
		return forward;
	}

}
