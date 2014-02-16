package model;

import java.util.Date;

public class Hit {

	long id;
	long userId;
	long shareId;
	double newPrice;
	double oldPrice;
	Date date;
	
	public Hit() {
		super();
	}

	public Hit( long userId, long shareId,
			double newPrice, double oldPrice, Date date) {
		super();
		
		this.userId = userId;
		this.shareId = shareId;
		this.newPrice = newPrice;
		this.oldPrice = oldPrice;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getShareId() {
		return shareId;
	}

	public void setShareId(long shareId) {
		this.shareId = shareId;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
