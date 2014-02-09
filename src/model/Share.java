package model;

import java.util.Date;

public class Share {
 
	long id;
	String name;
	Double price;
	Date insertedDate;
	Boolean active;
	Date activateDate;
	Date deactivateDate;
	
	
	
	public Share() {
		super();
	}
	public Share(String name, Double price, Date insertedDate, Boolean active,
			Date activateDate, Date deactivateDate) {
		super();
		this.name = name;
		this.price = price;
		this.insertedDate = insertedDate;
		this.active = active;
		this.activateDate = activateDate;
		this.deactivateDate = deactivateDate;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getInsertedDate() {
		return insertedDate;
	}
	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getActivateDate() {
		return activateDate;
	}
	public void setActivateDate(Date activateDate) {
		this.activateDate = activateDate;
	}
	public Date getDeactivateDate() {
		return deactivateDate;
	}
	public void setDeactivateDate(Date deactivateDate) {
		this.deactivateDate = deactivateDate;
	}
	
	
	
}

