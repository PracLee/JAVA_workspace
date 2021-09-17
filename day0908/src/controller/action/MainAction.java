package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import model.CommentReply;
import model.CommentVO;
import model.ReplyVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String action = request.getParameter("action");
		System.out.println(action);
		String url="ctrl.jsp?action=goMain";	
		String mcntt=request.getParameter("mcnt");
		int mcnt=1;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}
		url= url+ "&mcnt="+mcnt;
		request.setAttribute("url", url);
		ArrayList<CommentReply> datas = new ArrayList<CommentReply>();
		ArrayList<CommentVO> Cdata = CommentDAO.selectAll(mcnt);
		for(int i=0;i<Cdata.size();i++){
			ArrayList<ReplyVO> Rdata = ReplyDAO.selectAll(Cdata.get(i).getcNum());	// ��� ���� ��������
			CommentReply cr = new CommentReply();
			cr.setC(Cdata.get(i));
			cr.setrList(Rdata);
			datas.add(cr);
		}
		//session.setAttribute("mcnt", mcnt);
		request.setAttribute("datas", datas);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");

		return forward;
	}

}
