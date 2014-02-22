import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import utils.Mailer;
 
public class Main {
 
	public static void main(String[] args) {
 
		Mailer.sendMail("alefas88@gmail.com", "sadas", "sdfsa");
	}
}
