package model;

import java.util.Date;

public class CallForBuy {

	long id;
	long callerId;
	long panelId;
	Date date;
	long shareId;
	
	
	
	public CallForBuy() {
		super();
	}
	public CallForBuy( long callerId, long panelId, Date date,
			long shareId) {
		super();
		
		this.callerId = callerId;
		this.panelId = panelId;
		this.date = date;
		this.shareId = shareId;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public long getCallerId() {
		return callerId;
	}
	public void setCallerId(long callerId) {
		this.callerId = callerId;
	}
	public long getPanelId() {
		return panelId;
	}
	public void setPanelId(long panelId) {
		this.panelId = panelId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getShareId() {
		return shareId;
	}
	public void setShareId(long shareId) {
		this.shareId = shareId;
	}
	
	
	
}

 
