package com.capgemini.service;

import com.capgemini.entity.AssociateProf;
import com.capgemini.exception.OperationException;

public interface OperationService {


	public Integer addAssociateDetails(AssociateProf operationTeam) throws OperationException;

	//public List<OperationTeam> getAllAssociateDetails() throws OperationException;

	public AssociateProf updateAssociateDetails(AssociateProf operationTeam) throws OperationException;
}
