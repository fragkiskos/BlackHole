package model;

import java.util.Date;

public class ExchangePanel {
	
	long id;
	boolean isclosed;
	long shareId;
	Date createdDate;
	Date closedDate;
	
	
	
	public ExchangePanel() {
		super();
	}



	public ExchangePanel( boolean isclosed, long shareId,
			Date createdDate, Date closedDate) {
		super();
		
		this.isclosed = isclosed;
		this.shareId = shareId;
		this.createdDate = createdDate;
		this.closedDate = closedDate;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public boolean isIsclosed() {
		return isclosed;
	}



	public void setIsclosed(boolean isclosed) {
		this.isclosed = isclosed;
	}



	public long getShareId() {
		return shareId;
	}



	public void setShareId(long shareId) {
		this.shareId = shareId;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getClosedDate() {
		return closedDate;
	}



	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	
	

}

