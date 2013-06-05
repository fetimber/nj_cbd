package com.fe.bean.xml;

import java.util.Date;


public class ClientInfo {
	
	//平台IP
	private String ip;
	//公众账号验证TOKEN
	private String token;
	//微信号
	private String weiXinId;
	//微信名称
	private String weiXinName;
	//创建时间
	private Date createTime;
	//到期时间
	private Date endTime;
	//公众账号状态
	private String clientStatus;
	//公司名称
	private String companyName;
	//地区
	private String areaDesc;
	//登录管理账号
	private String clientAdmin;
	//密文密码
	private String clientPassWord;
	//联系电话
	private String contactNumber;
	//备注
	private String remark;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getWeiXinId() {
		return weiXinId;
	}
	public void setWeiXinId(String weiXinId) {
		this.weiXinId = weiXinId;
	}
	public String getWeiXinName() {
		return weiXinName;
	}
	public void setWeiXinName(String weiXinName) {
		this.weiXinName = weiXinName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public String getClientAdmin() {
		return clientAdmin;
	}
	public void setClientAdmin(String clientAdmin) {
		this.clientAdmin = clientAdmin;
	}
	public String getClientPassWord() {
		return clientPassWord;
	}
	public void setClientPassWord(String clientPassWord) {
		this.clientPassWord = clientPassWord;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
