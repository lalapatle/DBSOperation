package com.capgemini.service;

import java.util.List;

import javax.management.openmbean.OpenDataException;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.AssociateProf;
import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;

public interface OperationService {

	
	public Integer addAssociateDetails(AssociateProf associateProf) throws OperationException;

	//public List<OperationTeam> getAllAssociateDetails() throws OperationException;
	
	 

	public AssociateProf updateAssociateDetails(AssociateProf associateProf) throws OperationException;
}
