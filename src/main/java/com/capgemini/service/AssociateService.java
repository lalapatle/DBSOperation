
package com.capgemini.service;


import java.util.List;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.exception.AssociateException;

public interface AssociateService
{
	public Integer addAssociate(AssociatePersonal associatePersonal) throws AssociateException;

	public AssociatePersonal getAssociateById(Integer id) throws AssociateException;

	public AssociatePersonal updateAssociate(AssociatePersonal associatePersonal) throws AssociateException;

}

