package com.capgemini.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import com.capgemini.entity.AssociateProf;

import com.capgemini.entity.AssociateProf;


import com.capgemini.exception.OperationException;
import com.capgemini.repository.OperationRepository;

public class OperationServiceImpl implements OperationService{

	@Autowired
	private OperationRepository operationRepository;

	@Override

	public Integer addAssociateDetails(AssociateProf associateDetails) throws OperationException 
	{
		try 
		{
			operationRepository.save(associateDetails);
			return 1;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new OperationException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception) 
		{
			throw new OperationException(exception.getMessage(),exception);
		}
	}

	@Override
	public AssociateProf updateAssociateDetails(AssociateProf associateDetails) throws OperationException 
	{
		try 
		{            
			AssociateProf updatedAssociate= operationRepository.save(associateDetails);    
			return updatedAssociate;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new OperationException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new OperationException(exception.getMessage(),exception);
		}

	}

}