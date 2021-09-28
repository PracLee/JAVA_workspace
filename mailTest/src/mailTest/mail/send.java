package mailTest.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class send
 */
@WebServlet("*.send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public send() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.user", "bjlee.spsbsc@gamil.com");	// 서버 아이디만 쓰기
		prop.put("mail.smtp.host", "smtp.gmail.com");	// 구글 SMTP
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.soketFactory.port","465");
		prop.put("mail.smtp.soketFactory.class","javax.net.ssl.SSLSoketFactory");
		prop.put("mail.smtp.soketFactory.fallback","false");

		Authenticator auth = new Mail();

		//Session 생성 및 MimeMessage 생성
		Session session = Session.getDefaultInstance(prop, auth);
		MimeMessage msg = new MimeMessage(session);
		try {
			// 보낸시간 현재
			msg.setSentDate(new Date());	

			// 보내는 사람, 이름
			msg.setFrom(new InternetAddress("bjlee.spsbsc@gmail.com", "4GTAdmin"));	

			// 수신자
			String email = request.getParameter("receiver");	// 사용자가 입력한 값을 받아옴
			InternetAddress to = new InternetAddress(email);

			// 메일 제목
			msg.setSubject("인증번호 확인", "UTF-8");

			// 메일 내용
			String code = request.getParameter("code_check");
			msg.setText("아이디·비밀번호 찾기 인증번호는[ "+code+" ] 입니다. 타인에게 절대 노출하지 마세요", "UTF-8");         
			request.setAttribute("code", code); 	// 다음페이지에서 코드 확인

			// 참조인
			msg.setRecipient(Message.RecipientType.TO, to);

			// 메일 보내기
			Transport.send(msg);
			System.out.println("보냇당!");

		} catch(AddressException ae) {            
			System.out.println("AddressException : " + ae.getMessage());           
		} catch(MessagingException me) {            
			System.out.println("MessagingException : " + me.getMessage());
		} catch(UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage());
		}
		
		// 인증번호 확인페이지로 이동
		RequestDispatcher rd = request.getRequestDispatcher("checkMailCode.jsp");
		rd.forward(request, response);
	}
}
