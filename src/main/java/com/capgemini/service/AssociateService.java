
package com.capgemini.service;


import java.util.List;

import com.capgemini.entity.Associate;
import com.capgemini.exception.AssociateException;

public interface AssociateService
{
	public Integer addAssociate(Associate associate) throws AssociateException;

	public Associate getAssociateById(Integer id) throws AssociateException;

	public Associate updateAssociate(Associate associate) throws AssociateException;

}

