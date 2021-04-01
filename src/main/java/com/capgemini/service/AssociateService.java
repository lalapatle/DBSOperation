
package com.capgemini.service;


import com.capgemini.entity.AssociatePersonal;
import com.capgemini.exception.AssociateException;

public interface AssociateService
{
	public Integer addAssociate(AssociatePersonal associate) throws AssociateException;

	public AssociatePersonal getAssociateById(Integer id) throws AssociateException;

	public AssociatePersonal updateAssociate(AssociatePersonal associate) throws AssociateException;
}

