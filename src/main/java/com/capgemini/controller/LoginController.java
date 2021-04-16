package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.ChangePassword;
import com.capgemini.entity.Login;
import com.capgemini.exception.LoginException;
import com.capgemini.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@RequestMapping("/dbsoApp")
@Slf4j
public class LoginController 
{
	@Autowired
	private LoginService loginService; 

	//localhost:8080/dbsoApp/login
	@PostMapping(value="/login")
	public ResponseEntity<Login> userLogin(@RequestBody Login login) {
		try {
			Login loginuser=loginService.login(login);
			return new ResponseEntity<Login>(loginuser, HttpStatus.OK);	
		} catch (LoginException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@GetMapping("/{cgGroupId}")
	public ResponseEntity<AssociatePersonal> getDetailsById(@PathVariable Integer cgGroupId) throws AssociateException {
		try {
			AssociatePersonal associatePersonal=loginService.getAssociateById(cgGroupId);
			if(associatePersonal==null) {
				throw new AssociateException("No record found for given id");
			}
			return new ResponseEntity<AssociatePersonal>(associatePersonal,HttpStatus.OK);

		} catch (LoginException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	//localhost:8080/dbsoApp/reset
	@PostMapping("/reset")
	public ResponseEntity<?> changePassword( @RequestBody ChangePassword changePassword) throws LoginException {
		try
		{
			String str =loginService.changePassword(changePassword);

			return new ResponseEntity<>(str, HttpStatus.OK);
		}
		catch (LoginException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}
