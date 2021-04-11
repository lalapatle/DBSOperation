package com.capgemini.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.AssociateProf;
import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;
import com.capgemini.repository.AssociateRepository;
import com.fasterxml.jackson.core.sym.Name;

@Service("associateService")
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
			AssociatePersonal associate1=associateRepository.getOne(associate.getCgGroupId());
			if (associate1!=null) {
				return associateRepository.save(associate1);
			}else {
				throw new AssociateException("No record found");
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

	@Override
	public List<AssociatePersonal> getAllAssociatePersonalDetails() throws AssociateException {
		try 
		{            
			List<AssociatePersonal> associatePerList=associateRepository.findAll();
			return associatePerList;
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