package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.AssociateProf;
import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;

public interface OperationService {


	public Integer addAssociateProfDetails( Integer cgGroupId,AssociateProf associateProf) throws OperationException;

	public List<AssociateProf> getAllAssociateProfDetails() throws OperationException;

	public AssociateProf getAssociateProfById(Integer sNo) throws OperationException;

	public AssociateProf updateAssociateProfDetails(AssociateProf associateProf) throws OperationException;
	
	public Integer deleteAssociateData(Integer sNo) throws OperationException;


	public AssociateProf getAssociateProfByCgGroupId(Integer cgGroupId) throws OperationException;


}