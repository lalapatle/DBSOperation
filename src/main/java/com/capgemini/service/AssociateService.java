
package com.capgemini.service;


import java.util.List;

import com.capgemini.entity.AssociatePersonal;

import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;

public interface AssociateService
{
	public Integer addAssociate(AssociatePersonal associate) throws AssociateException;

	
	public List<AssociatePersonal> getAllAssociatePersonalDetails() throws AssociateException;

	public AssociatePersonal getAssociateById(Integer id) throws AssociateException;



	public AssociatePersonal updateAssociate(AssociatePersonal associate) throws AssociateException;
}
