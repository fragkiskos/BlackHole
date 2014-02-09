package model;

public class Company {

	long id;
	Long shareId;
	String logoUrl;
	String name;
	String description;
	String siteUrl;
	Long userId;
	
	
	public Company(){}
	
	public Company(Long shareId, String logoUrl, String name,
			String description, String siteUrl, Long userId) {
		super();
		this.shareId = shareId;
		this.logoUrl = logoUrl;
		this.name = name;
		this.description = description;
		this.siteUrl = siteUrl;
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public long getShareId() {
		return shareId;
	}
	public void setShareId(long shareId) {
		this.shareId = shareId;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}
 