package mailTest.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Mail extends Authenticator{
	// 각자의 구글 아이디를 입력
	PasswordAuthentication pa;
	public Mail() {
		String mail_id = "구글메일아이디입력 @gmail.com";
		String mail_pw = "비밀번호입력";
		pa = new PasswordAuthentication(mail_id, mail_pw);
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
