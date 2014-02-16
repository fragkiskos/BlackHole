package model;

public class PanelBuyers {

	long id;
	long buyerId;
	long panelId;
	
	
	
	public PanelBuyers() {
		super();
	}



	public PanelBuyers( long buyerId, long panelId) {
		super();
		
		this.buyerId = buyerId;
		this.panelId = panelId;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getBuyerId() {
		return buyerId;
	}



	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}



	public long getPanelId() {
		return panelId;
	}



	public void setPanelId(long panelId) {
		this.panelId = panelId;
	}
	
	
	
}
