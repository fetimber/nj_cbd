package com.fe.bean;

public class UserInfo {
	private String userName;

	private String userPassWord;

	private Integer id;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override   
	public String toString()
	{      
		return "User [uid=" + id + ", uname=" + userName + ", upwd=" + userPassWord + "]";  
	}
}
