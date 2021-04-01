package com.capgemini.service;

import java.util.List;

import javax.management.openmbean.OpenDataException;

import com.capgemini.entity.Associate;
import com.capgemini.entity.OperationTeam;
import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;

public interface OperationService {

	
	public Integer addAssociateDetails(OperationTeam operationTeam) throws OperationException;

	//public List<OperationTeam> getAllAssociateDetails() throws OperationException;
	
	 

	public OperationTeam updateAssociateDetails(OperationTeam operationTeam) throws OperationException;
}
