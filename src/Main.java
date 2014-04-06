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

import model.Notification;
import utils.DateUtils;
import utils.Mailer;
import utils.dbUtils.DbTransactions;
import utils.messageUtil.Messager;
import utils.modelUtils.UserUtil;
 
public class Main {
 
	public static void main(String[] args) {
		Date now = new Date();
		long userId = 4;
		Boolean readed=false;
		Notification not = new Notification( "sfsfsd", readed, userId, now);
		for(int i=0;i<10;i++){
			DbTransactions.storeObject(not);
		}
		
	}
}
