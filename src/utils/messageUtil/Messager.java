package utils.messageUtil;

import java.util.Date;
import java.util.List;

import utils.dbUtils.DbTransactions;
import model.Message;
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
	
	public static int getIncomingUnReadedCount(){
		List<Message> incomingMessages = (List<Message>)(List<?>)DbTransactions.getObjectsByProperty(Message.class.getCanonicalName(), "readed", 0);
		return incomingMessages.size();
	}
	
	
}
