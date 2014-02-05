package model;

public class BreakingNew {
	
	private String title;
	private String subTitle;
	private String imageUrl;
	private String url;
	
	
	public BreakingNew() {
	}


	public BreakingNew(String title, String subTitle, String imageUrl, String url) {
		this.title = title;
		this.subTitle = subTitle;
		this.imageUrl = imageUrl;
		this.url=url;
	}


	


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubTitle() {
		return subTitle;
	}


	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	

}
