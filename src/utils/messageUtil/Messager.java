package utils.messageUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.dbUtils.DbTransactions;
import model.Message;
import model.Notification;
import model.User;

public class Messager {

	public static boolean sendMessage(Message message){
		return DbTransactions.storeObject(message); 
	}
	
	public static Message getMessage(long id){
		Message message = (Message) DbTransactions.getObjectById(Message.class.getCanonicalName(), id);
		return message;
	}
	
	public static List<Message> getIncoming(long userId){
		List<Message> incomingMessages = (List<Message>)(List<?>)DbTransactions.getObjectsByPropertyOrderBy(Message.class.getCanonicalName(), "recieverId", userId,"date");
		return incomingMessages;
	}
	public static List<Notification> getNotifications(long userId){
		List<Notification> notifications = (List<Notification>)(List<?>)DbTransactions.getObjectsByPropertyOrderBy(Notification.class.getCanonicalName(), "userId", userId,"date");
		return notifications;
	}
	public static List<Message> getOutGoing(long userId){
		List<Message> outgoingMessages = (List<Message>)(List<?>)DbTransactions.getObjectsByPropertyOrderBy(Message.class.getCanonicalName(), "senderId", userId,"date");
		return outgoingMessages;
	}
	
	public static boolean replyMessage(Message message,String text){
		Date date = new Date();
		Message reply = new Message( message.getReceiverId(), message.getSenderId(), text, message.getText(), date, false);
		return DbTransactions.storeObject(reply);
	}
	
	public static boolean deleteMessage(Message message){
		return DbTransactions.deleteObjectById(Message.class.getCanonicalName(), message.getId());
	}
	
	public static boolean deleteMessages(List<Message> messages){
		boolean ok = true;
		for(int i=0;i<messages.size();i++){
			ok = deleteMessage(messages.get(i));
		}
		return ok;
	}
	
	public static int getIncomingUnReadedCount(long userId){
		Map<Object,Object> properties = new HashMap<Object,Object>();
		properties.put("recieverId", userId);
		properties.put("readed", false);
		List<Message> incomingMessages = (List<Message>)(List<?>)DbTransactions.getObjectsByProperties(Message.class.getCanonicalName(), properties);
		return incomingMessages.size();
	}
	
	public static int getUnreadedNotifications(long userId){
		Map<Object,Object> properties = new HashMap<Object,Object>();
		properties.put("userId", userId);
		properties.put("readed", false);
		List<Notification> incomingMessages = (List<Notification>)(List<?>)DbTransactions.getObjectsByProperties(Notification.class.getCanonicalName(), properties);
		return incomingMessages.size();
	}
	
	
}
