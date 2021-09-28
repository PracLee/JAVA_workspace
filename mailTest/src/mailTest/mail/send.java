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
		prop.put("mail.smtp.user", "bjlee.spsbsc@gamil.com");	// ���� ���̵� ����
		prop.put("mail.smtp.host", "smtp.gmail.com");	// ���� SMTP
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.soketFactory.port","465");
		prop.put("mail.smtp.soketFactory.class","javax.net.ssl.SSLSoketFactory");
		prop.put("mail.smtp.soketFactory.fallback","false");

		Authenticator auth = new Mail();

		//Session ���� �� MimeMessage ����
		Session session = Session.getDefaultInstance(prop, auth);
		MimeMessage msg = new MimeMessage(session);
		try {
			// �����ð� ����
			msg.setSentDate(new Date());	

			// ������ ���, �̸�
			msg.setFrom(new InternetAddress("bjlee.spsbsc@gmail.com", "4GTAdmin"));	

			// ������
			String email = request.getParameter("receiver");	// ����ڰ� �Է��� ���� �޾ƿ�
			InternetAddress to = new InternetAddress(email);

			// ���� ����
			msg.setSubject("������ȣ Ȯ��", "UTF-8");

			// ���� ����
			String code = request.getParameter("code_check");
			msg.setText("���̵𡤺�й�ȣ ã�� ������ȣ��[ "+code+" ] �Դϴ�. Ÿ�ο��� ���� �������� ������", "UTF-8");         
			request.setAttribute("code", code); 	// �������������� �ڵ� Ȯ��

			// ������
			msg.setRecipient(Message.RecipientType.TO, to);

			// ���� ������
			Transport.send(msg);
			System.out.println("������!");

		} catch(AddressException ae) {            
			System.out.println("AddressException : " + ae.getMessage());           
		} catch(MessagingException me) {            
			System.out.println("MessagingException : " + me.getMessage());
		} catch(UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage());
		}
		
		// ������ȣ Ȯ���������� �̵�
		RequestDispatcher rd = request.getRequestDispatcher("checkMailCode.jsp");
		rd.forward(request, response);
	}
}
