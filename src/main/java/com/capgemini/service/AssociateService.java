
package com.capgemini.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.capgemini.entity.AssociatePersonal;

import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;

public interface AssociateService
{
	public Integer addAssociate(AssociatePersonal associate) throws AssociateException;

	
	public List<AssociatePersonal> getAllAssociatePersonalDetails() throws AssociateException;

	public AssociatePersonal getAssociateById(Integer id) throws AssociateException;



	public AssociatePersonal updateAssociate(AssociatePersonal associate) throws AssociateException;
	
	
	//For pancard
	public boolean uploadFile(MultipartFile file,Integer cgGroupId) throws AssociateException;
	
	public byte[] getFileById(Integer cgGroupId) throws AssociateException;;
	
	public String getFileNameById(Integer cgGroupId) throws AssociateException;
	
	
	//for passport
    public boolean uploadFile1(MultipartFile file1,Integer cgGroupId) throws AssociateException;
	
	public byte[] getFileById1(Integer cgGroupId) throws AssociateException;;
	
	public String getFileNameById1(Integer cgGroupId) throws AssociateException;
	
	
	//For CV
	public boolean uploadCv(MultipartFile cvr,Integer cgGroupId) throws AssociateException;
	
	public byte[] getFileById2(Integer cgGroupId) throws AssociateException;;
	
	public String getFileNameById2(Integer cgGroupId) throws AssociateException;


}
