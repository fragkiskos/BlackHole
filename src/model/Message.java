package model;

import java.util.Date;

public class Message {

	long id;
	long senderId;
	long receiverId;
	String text;
	String theme;
	Date date;
	Boolean readed;
	
	
	
	
	public Message() {
		
	}




	




	public Message( long senderId, long receiverId, String text,
			String theme, Date date, Boolean readed) {
		
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.text = text;
		this.theme = theme;
		this.date = date;
		this.readed = readed;
	}









	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public long getSenderId() {
		return senderId;
	}




	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}




	public long getReceiverId() {
		return receiverId;
	}




	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}




	public String getText() {
		return text;
	}




	public void setText(String text) {
		this.text = text;
	}




	public String getTheme() {
		return theme;
	}




	public void setTheme(String theme) {
		this.theme = theme;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public Boolean getReaded() {
		return readed;
	}




	public void setReaded(Boolean readed) {
		this.readed = readed;
	}
	
	
	
}
 