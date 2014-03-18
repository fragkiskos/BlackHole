import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import utils.Mailer;
import utils.messageUtil.Messager;
import utils.modelUtils.UserUtil;
 
public class Main {
 
	public static void main(String[] args) {
		long a = 3;
		Object o = a;
		System.out.println(o.getClass().getCanonicalName());
	}
}
