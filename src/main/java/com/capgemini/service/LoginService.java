package com.capgemini.service;

import com.capgemini.entity.ChangePassword;

import com.capgemini.entity.Login;
import com.capgemini.exception.LoginException;

public interface LoginService {

	Login login(Login login) throws LoginException;


	Login getAssociateById(Integer cgGroupId) throws LoginException;
	
	
//	public void sendCredentialMail(Login user) throws MessagingException;


	
	public String changePassword(ChangePassword changePassword) throws LoginException;

}
