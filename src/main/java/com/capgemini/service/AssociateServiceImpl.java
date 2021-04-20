package com.capgemini.service;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.exception.AssociateException;
import com.capgemini.repository.AssociateRepository;

@Service("associateService")
public class AssociateServiceImpl implements AssociateService{

	@Autowired
	private AssociateRepository associateRepository;

	@Override
	public Integer addAssociate(AssociatePersonal associate) throws AssociateException 
	{
		try 
		{
			LocalDate doj= associate.getDateOfJoiningCGCompany();
			LocalDate currentDate = LocalDate.now();
			
		
			int overall= (associate.getOverallExperienceBeforeJoiningCg());
			associate.setTotalExperience((Period.between(doj,currentDate).getMonths())+ overall);
			associateRepository.save(associate);
			return 1;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception) 
		{
			throw new AssociateException(exception.getMessage(),exception);
		}

	
	}

	@Override

	public AssociatePersonal updateAssociate(AssociatePersonal associate) throws AssociateException
	{
		try 
		{   
			AssociatePersonal associate1=associateRepository.getOne(associate.getCgGroupId());
			if (associate1!=null) {
				
				return associateRepository.save(associate1);
			}else {
				throw new AssociateException("No record found");
			}
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new AssociateException(exception.getMessage(),exception);
		}

	
	}
	@Override

	public AssociatePersonal getAssociateById(Integer id) throws AssociateException 
	{
		try 
		{
			Optional<AssociatePersonal> optional= 
					associateRepository.findById(id);
			if(optional.isPresent())
			{
				System.out.println(optional.get());
				return optional.get();
			}
			else 
			{
				return null;
			}			
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception) 
		{
			throw new AssociateException(exception.getMessage(),exception);
		}	
	}

	@Override
	public List<AssociatePersonal> getAllAssociatePersonalDetails() throws AssociateException {
		try 
		{            
			List<AssociatePersonal> associatePerList=associateRepository.findAll();
			return associatePerList;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new AssociateException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new AssociateException(exception.getMessage(),exception);
		}
	}
	
	@Override
	public boolean uploadFile(MultipartFile file, Integer cgGroupId) throws AssociateException {
		
		boolean isUpload=false;

		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			String fileName=StringUtils.cleanPath(file.getOriginalFilename());
	        associatePersonal.setFile(file.getBytes());
			associatePersonal.setFileName(fileName);
			associateRepository.save(associatePersonal);
			isUpload=true;
			
	        }
		catch(DataAccessException | IOException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
		return isUpload;
	}

	@Override
	public byte[] getFileById(Integer cgGroupId) throws AssociateException {
		
		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			return associatePersonal.getFile();
	        }
		catch(DataAccessException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
	}

	@Override
	public String getFileNameById(Integer cgGroupId) throws AssociateException {
		
		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			return associatePersonal.getFileName();
	        }
		catch(DataAccessException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
	}

	@Override
	public boolean uploadFile1(MultipartFile file1, Integer cgGroupId) throws AssociateException {
		
		boolean isUpload=false;
		
			try {
				AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
				String fileName=StringUtils.cleanPath(file1.getOriginalFilename());
		        associatePersonal.setFile1(file1.getBytes());
				associatePersonal.setFileName1(fileName);
				associateRepository.save(associatePersonal);
				isUpload=true;
				
		        }
			catch(DataAccessException | IOException e)
			{
				throw new AssociateException(e.getMessage(),e);
			}
			return isUpload;
	}

	@Override
	public byte[] getFileById1(Integer cgGroupId) throws AssociateException {
		
		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			return associatePersonal.getFile1();
	        }
		catch(DataAccessException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
	}

	@Override
	public String getFileNameById1(Integer cgGroupId) throws AssociateException {
		
		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			return associatePersonal.getFileName1();
	        }
		catch(DataAccessException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public boolean uploadCv(MultipartFile cvr, Integer cgGroupId) throws AssociateException {
		
		boolean isUpload=false;
		
			try {
				AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
				String fileName=StringUtils.cleanPath(cvr.getOriginalFilename());
		        associatePersonal.setCvr(cvr.getBytes());
				associatePersonal.setCvresume(fileName);
				associateRepository.save(associatePersonal);
				isUpload=true;
				
		        }
			catch(DataAccessException | IOException e)
			{
				throw new AssociateException(e.getMessage(),e);
			}
			return isUpload;
	}

	@Override
	public byte[] getFileById2(Integer cgGroupId) throws AssociateException {

		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			return associatePersonal.getCvr();
	        }
		catch(DataAccessException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
	}

	@Override
	public String getFileNameById2(Integer cgGroupId) throws AssociateException {
	
		try {
			AssociatePersonal associatePersonal = associateRepository.findById(cgGroupId).get();
			return associatePersonal.getCvresume();
	        }
		catch(DataAccessException e)
		{
			throw new AssociateException(e.getMessage(),e);
		}
	}
	
	

}