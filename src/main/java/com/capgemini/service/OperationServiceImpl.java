package com.capgemini.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.AssociateProf;

import com.capgemini.exception.OperationException;
import com.capgemini.repository.AssociateRepository;
import com.capgemini.repository.OperationRepository;

@Service("operationService")
public class OperationServiceImpl implements OperationService{

	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private AssociateRepository associateRepository;

	@Override

	public Integer addAssociateProfDetails( Integer cgGroupId,AssociateProf associateDetails) throws OperationException 
	{
		try 
		{
			Optional<AssociatePersonal> optional=associateRepository.findById(cgGroupId);
			AssociatePersonal aPersonal=null;
			if(optional.isPresent()) {
				aPersonal=optional.get();
			}
			associateDetails.setAssociatePersonal(aPersonal);
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
	public AssociateProf updateAssociateProfDetails(AssociateProf associateDetails) throws OperationException 
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

	@Override
	public List<AssociateProf> getAllAssociateProfDetails() throws OperationException {
		try 
		{            
			List<AssociateProf> associateProfList=operationRepository.findAll();
			return associateProfList;
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
	public AssociateProf getAssociateProfById(Integer sNo) throws OperationException {
		try 
		{            
			AssociateProf associateProf=operationRepository.findById(sNo).get();
			return associateProf;
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
	public Integer deleteAssociateData(Integer sNo) throws OperationException {
		try {
			AssociateProf associateProf=operationRepository.findById(sNo).get();
			operationRepository.deleteById(associateProf.getSNo());
			return sNo;
		}
		catch(Exception exception) {
			throw new OperationException(exception.getMessage(),exception);
		}
		
	}

}