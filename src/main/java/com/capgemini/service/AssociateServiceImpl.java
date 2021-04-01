package com.capgemini.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;



import com.capgemini.entity.AssociatePersonal;
import com.capgemini.exception.AssociateException;
import com.capgemini.repository.AssociateRepository;

public class AssociateServiceImpl implements AssociateService{

	@Autowired
	private AssociateRepository associateRepository;

	@Override
	public Integer addAssociate(AssociatePersonal associate) throws AssociateException 
	{
		try 
		{
			associateRepository.save(associate);
			return 1;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception) 
		{
			throw new AssociateException(exception.getMessage(),exception);
		}

	
	}

	@Override

	public AssociatePersonal updateAssociate(AssociatePersonal associate) throws AssociateException
	{
		try 
		{            
			AssociatePersonal updatedAssociate= associateRepository.save(associate);    
			return updatedAssociate;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new AssociateException(exception.getMessage(),exception);
		}

	
	}
	@Override

	public AssociatePersonal getAssociateById(Integer id) throws AssociateException 
	{
		try 
		{
			Optional<AssociatePersonal> optional= 
					associateRepository.findById(id);
			if(optional.isPresent())
			{
				System.out.println(optional.get());
				return optional.get();
			}
			else 
			{
				return null;
			}			
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception) 
		{
			throw new AssociateException(exception.getMessage(),exception);
		}	
	}
	

}