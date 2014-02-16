package model;

public class PanelExchanges {

	long id;
	long exchangeId;
	long panelId;
	
	public PanelExchanges() {
		super();
	}

	public PanelExchanges( long exchangeId, long panelId) {
		super();
		
		this.exchangeId = exchangeId;
		this.panelId = panelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(long exchangeId) {
		this.exchangeId = exchangeId;
	}

	public long getPanelId() {
		return panelId;
	}

	public void setPanelId(long panelId) {
		this.panelId = panelId;
	}
	
	
}
