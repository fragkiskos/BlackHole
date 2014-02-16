package model;

public class PanelSellers {

	long id;
	long sellerId;
	long panelId;
	
	public PanelSellers() {
		super();
	}

	public PanelSellers(long sellerId, long panelId) {
		super();
		
		this.sellerId = sellerId;
		this.panelId = panelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public long getPanelId() {
		return panelId;
	}

	public void setPanelId(long panelId) {
		this.panelId = panelId;
	}
	
	
	
}
