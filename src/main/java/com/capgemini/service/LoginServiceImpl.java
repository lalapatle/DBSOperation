package com.capgemini.service;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

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
	
//	@Autowired
//	private JavaMailSender mailSender;
	
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
	public Login getAssociateById(Integer cgGroupId) throws LoginException {
		try 
		{
			Optional<Login> optionallogin= 
					loginRepo.findById(cgGroupId);
			if(optionallogin.isPresent()) {
				
				
					return optionallogin.get();
					
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
	
//	@Override
//	public void sendCredentialMail(Login user) throws MessagingException {
//		String subject="TLTA CREDENTIALS";
//		String mailContent="<p> Dear "+user.getRole()+",</p>";
//		mailContent+="<p> Your Account is created for Technology Learning and Tracking Application.</p>";
//		mailContent+="<p> Your credentials are: <br>USER EmailID : "+user.getEmail()+"<br>PASSWORD: "+user.getPassword()+"</p>"+"<p>"+user.getRole()+"</p>";
//		mailContent+="<p> Regards,<br>TLTA Teams</p>";
//		MimeMessage message=mailSender.createMimeMessage();
//		MimeMessageHelper helper=new MimeMessageHelper(message);
//		helper.setFrom("tltaproject2@gmail.com");
//		helper.setTo(user.getEmail());
//		helper.setSubject(subject);
//		helper.setText(mailContent, true);
//		mailSender.send(message);
//	}
	

}
