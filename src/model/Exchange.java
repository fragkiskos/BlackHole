package model;

import java.util.Date;

public class Exchange {

	long id;
	Date exchangeTimestamp;
	long sellerId;
	long buyerId;
	long shareId;
	double price;
	long quantity;
	
	
	public Exchange() {
		super();
	}


	public Exchange( Date exchangeTimestamp, long sellerId,
			long buyerId, long shareId, double price, long quantity) {
		super();
		
		this.exchangeTimestamp = exchangeTimestamp;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.shareId = shareId;
		this.price = price;
		this.quantity = quantity;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getExchangeTimestamp() {
		return exchangeTimestamp;
	}


	public void setExchangeTimestamp(Date exchangeTimestamp) {
		this.exchangeTimestamp = exchangeTimestamp;
	}


	public long getSellerId() {
		return sellerId;
	}


	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}


	public long getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}


	public long getShareId() {
		return shareId;
	}


	public void setShareId(long shareId) {
		this.shareId = shareId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
