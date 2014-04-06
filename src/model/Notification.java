package model;

import java.util.Date;

public class Notification {
	
	long id;
	String text;
	boolean readed;
	long userId;
	Date date;
	
	
	
	public Notification() {
		super();
	}
	public Notification( String text, boolean readed, long userId,
			Date date) {
		super();
		this.id = id;
		this.text = text;
		this.readed = readed;
		this.userId = userId;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isReaded() {
		return readed;
	}
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
