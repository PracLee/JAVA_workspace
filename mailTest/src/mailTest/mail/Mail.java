package mailTest.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Mail extends Authenticator{
	// ������ ���� ���̵� �Է�
	PasswordAuthentication pa;
	public Mail() {
		String mail_id = "bjlee.spsbsc@gmail.com";
		String mail_pw = "2qudworne!";
		pa = new PasswordAuthentication(mail_id, mail_pw);
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
