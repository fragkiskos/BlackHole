package model;

public class PanelShareNegotiations {

	long id;
	long shareNegotiationId;
	long panelId;
	
	public PanelShareNegotiations() {
		super();
	}

	public PanelShareNegotiations( long shareNegotiationId, long panelId) {
		super();
		
		this.shareNegotiationId = shareNegotiationId;
		this.panelId = panelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getShareNegotiationId() {
		return shareNegotiationId;
	}

	public void setShareNegotiationId(long shareNegotiationId) {
		this.shareNegotiationId = shareNegotiationId;
	}

	public long getPanelId() {
		return panelId;
	}

	public void setPanelId(long panelId) {
		this.panelId = panelId;
	}
	
	
	
}
