package com.capgemini.service;

import javax.mail.MessagingException;


import com.capgemini.entity.Login;
import com.capgemini.exception.LoginException;

public interface LoginService {

	Login login(Login login) throws LoginException;

	Login getAssociateById(Integer cgGroupId) throws LoginException;
	
	
//	public void sendCredentialMail(Login user) throws MessagingException;

}
