package com.capgemini.entity;
public class ChangePassword 
{
	private Integer cgGroupId;
	private String oldPassword;
	private String newPassword;
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public Integer getCgGroupId() {
		return cgGroupId;
	}
	public void setCgGroupId(Integer cgGroupId) {
		this.cgGroupId = cgGroupId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
}