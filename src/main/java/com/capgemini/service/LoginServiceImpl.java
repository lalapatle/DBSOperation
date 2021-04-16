package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.ChangePassword;
import com.capgemini.entity.Login;
import com.capgemini.exception.LoginException;
import com.capgemini.repository.AssociateRepository;
import com.capgemini.repository.LoginRepository;

@Service("loginService")

public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepo;
	@Autowired
	AssociateRepository associateRepository;
	
	@Override
	public Login login(Login login) throws LoginException {
		
			Optional<Login> userlogin = loginRepo.findById(login.getCgGroupId());
			
			if(userlogin.isPresent())
			{
				Login user = userlogin.get();
				if(user.getPassword().equals(login.getPassword())){
							if(user.getRole().equals(login.getRole()))
							{
								return user;
							}
							else
							{
								throw new LoginException("User With this Role Does Not Exits");
							}
				}else{
					
					throw new LoginException("Invalid Password");
				}
			}else{
				
				throw new LoginException("Invalid Username");
			}
		
	}

	@Override
	public AssociatePersonal getAssociateById(Integer cgGroupId) throws LoginException {
		try 
		{
			Optional<Login> optionallogin= 
					loginRepo.findById(cgGroupId);
			if(optionallogin.isPresent()) {
				Optional<AssociatePersonal> optional= 
						associateRepository.findById(cgGroupId);
				
				if(optional.isPresent())
				{
					return optional.get();
				}
				else 
				{
					return null;
				}			
			}else {
				return null;
			}
				
			
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new LoginException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception) 
		{
			throw new LoginException(exception.getMessage(),exception);
		}	
	}
	
	@Override
	public String changePassword(ChangePassword changePassword) throws LoginException {
		String str = null;
		Optional<Login> loginObj = loginRepo.findById(changePassword.getCgGroupId());
		if (!loginObj.isPresent()) {
			throw new LoginException("USER NOT FOUND");
		} else {
			String pwd = loginObj.get().getPassword();
			if (!pwd.equals(changePassword.getOldPassword())) {
				throw new LoginException("WRONG PASSWORD");
			}
			try {
				loginObj.get().setPassword(changePassword.getNewPassword());
				loginRepo.saveAndFlush(loginObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new LoginException("OPERATION FAILED");
			}
		}
		return str;
	}

}
