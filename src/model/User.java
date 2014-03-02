package model;

import java.util.Date;

public class User {

	
	private long id;
	private String username; 
	private String email; 
	private String name;
	private String sirname; 
	private String phone; 
	private String loginService; 
	private Boolean locked=false; 
	private String password; 
	private String passQuestion; 
	private String passAnswer; 
	private Double frankos; 
	private Boolean active=true; 
	private Date InsertedDate; 
	private Date deactivateDate;
	private Boolean firstLogin=true; 
	
	
	
	
	public User() {
		super();
	}
	public User( String username, String email, String name,
			String sirname, String phone, String loginService, boolean locked,
			String password, String passQuestion, String passAnswer,
			Double frankos, boolean active, Date insertedDate,
			Date deactivateDate,boolean firstLogin) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.sirname = sirname;
		this.phone = phone;
		this.loginService = loginService;
		this.locked = locked;
		this.password = password;
		this.passQuestion = passQuestion;
		this.passAnswer = passAnswer;
		this.frankos = frankos;
		this.active = active;
		InsertedDate = insertedDate;
		this.deactivateDate = deactivateDate;
		this.firstLogin = firstLogin;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSirname() {
		return sirname;
	}
	public void setSirname(String sirname) {
		this.sirname = sirname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLoginService() {
		return loginService;
	}
	public void setLoginService(String loginService) {
		this.loginService = loginService;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassQuestion() {
		return passQuestion;
	}
	public void setPassQuestion(String passQuestion) {
		this.passQuestion = passQuestion;
	}
	public String getPassAnswer() {
		return passAnswer;
	}
	public void setPassAnswer(String passAnswer) {
		this.passAnswer = passAnswer;
	}
	public Double getFrankos() {
		return frankos;
	}
	public void setFrankos(Double frankos) {
		this.frankos = frankos;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getInsertedDate() {
		return InsertedDate;
	}
	public void setInsertedDate(Date insertedDate) {
		InsertedDate = insertedDate;
	}
	public Date getDeactivateDate() {
		return deactivateDate;
	}
	public void setDeactivateDate(Date deactivateDate) {
		this.deactivateDate = deactivateDate;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getFirstLogin() {
		return firstLogin;
	}
	public void setFirstLogin(Boolean firstLogin) {
		this.firstLogin = firstLogin;
	} 

	
	
	
}
