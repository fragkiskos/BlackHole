package model;

public class UsersShares {

	long id;
	long userId;
	long shareId;
	int sharesNumber;
	
	public UsersShares(){}
	 
	public UsersShares(long userId, long shareId, int sharesNumber) {
		super();
		this.userId = userId;
		this.shareId = shareId;
		this.sharesNumber = sharesNumber;
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
	public int getSharesNumber() {
		return sharesNumber;
	}
	public void setSharesNumber(int sharesNumber) {
		this.sharesNumber = sharesNumber;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	
	
}
 