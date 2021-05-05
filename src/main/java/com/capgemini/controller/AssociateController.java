package com.capgemini.controller;

import java.net.URLConnection;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.exception.AssociateException;
import com.capgemini.service.AssociateService;

import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin("*")
@RequestMapping("/dbsoApp")
@Slf4j
public class AssociateController {


	@Autowired
	private AssociateService associateService;

	//add associate
	//localhost:8080/dbsoApp/add-associate-personal
	@PostMapping("/add-associate-personal")
	public Integer addAssociatePersonalDetails(@RequestBody AssociatePersonal associatePersonal) {
		try {
			Integer status=associateService.addAssociate(associatePersonal);
			return status;	
		} catch (AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	//localhost:8080/dbsoApp/get-personal-details
	@GetMapping("/get-personal-details")
	public ResponseEntity<List<AssociatePersonal>> getAllAssociatePersonalDetails(){
		try {
			List<AssociatePersonal> associatePerList=associateService.getAllAssociatePersonalDetails();
			return new ResponseEntity<>(associatePerList,HttpStatus.OK);
		}
		catch (AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	//getAssociate by id
	//localhost:8080/dbsoApp/46056119
	@GetMapping("/{cgGroupId}")
	public ResponseEntity<AssociatePersonal> getAssociatePersonalDetailsById(@PathVariable Integer cgGroupId) {
		try {
			AssociatePersonal associatePersonal=associateService.getAssociateById(cgGroupId);
			if(associatePersonal==null) {
				throw new AssociateException("No record found for given id");
			}
			return new ResponseEntity<AssociatePersonal>(associatePersonal,HttpStatus.OK);

		} catch (AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//update associate
	//localhost:8080/dbsoApp/update/46056119
	@PutMapping("/update/{cgGroupId}")
	public ResponseEntity<AssociatePersonal> updateAssociatePersonalDetails(@PathVariable Integer cgGroupId,
			@RequestBody AssociatePersonal associatePersonal){
		try {
			
			
			AssociatePersonal ap=associateService.getAssociateById(cgGroupId);
			
			ap.setAssociateFullName(associatePersonal.getAssociateFullName());
			ap.setGender(associatePersonal.getGender());
			ap.setCgUserName(associatePersonal.getCgUserName());
			ap.setCgMailId(associatePersonal.getCgMailId());
			ap.setRegion(associatePersonal.getRegion());
			ap.setPractice(associatePersonal.getPractice());
			ap.setDesignation(associatePersonal.getDesignation());
			ap.setCgSupervisor(associatePersonal.getCgSupervisor());
			ap.setCgDBSAccountSupervisor(associatePersonal.getCgDBSAccountSupervisor());
			ap.setDbsClientLead(associatePersonal.getDbsClientLead());
			ap.setTower(associatePersonal.getTower());
			ap.setShortTower(associatePersonal.getShortTower());
			ap.setReasonResignation(associatePersonal.getReasonResignation());
			ap.setAssociateLocation(associatePersonal.getAssociateLocation());
			ap.setDateOfJoiningDBSAccount(associatePersonal.getDateOfJoiningDBSAccount());
			ap.setDateOfJoiningCGCompany(associatePersonal.getDateOfJoiningCGCompany());
			ap.setDbsBillableStartDate(associatePersonal.getDbsBillableStartDate());
			ap.setBankId(associatePersonal.getBankId());
			ap.setDbsMailId(associatePersonal.getDbsMailId());
			ap.setPrimarySkill(associatePersonal.getPrimarySkill());
			ap.setOverallExperienceBeforeJoiningCg(associatePersonal.getOverallExperienceBeforeJoiningCg());
//			ap.setTotalExperience(associatePersonal.getTotalExperience());
			//Update Experience
			LocalDate doj= associatePersonal.getDateOfJoiningCGCompany();
			LocalDate currentDate = LocalDate.now();
			int overall= (associatePersonal.getOverallExperienceBeforeJoiningCg());
			
			ap.setTotalExperience((Period.between(doj,currentDate).getMonths())+ overall);
			ap.setSowNumber(associatePersonal.getSowNumber());
			ap.setMandatoryTraining(associatePersonal.getMandatoryTraining());
			ap.setOnboardingDocs(associatePersonal.getOnboardingDocs());
			ap.setPanCard(associatePersonal.getPanCard());
			ap.setPassport(associatePersonal.getPassport());
			ap.setPassportExpiryDate(associatePersonal.getPassportExpiryDate());
			ap.setDateOfBirth(associatePersonal.getDateOfBirth());
			ap.setForeignEmploymentExperience(associatePersonal.getForeignEmploymentExperience());
			ap.setContact(associatePersonal.getContact());
			ap.setEmergencyContact(associatePersonal.getEmergencyContact());
			ap.setTemporaryAddress(associatePersonal.getTemporaryAddress());
			ap.setPermanentAddress(associatePersonal.getPermanentAddress());
			ap.setCsbForm(associatePersonal.getCsbForm());
			ap.setCgLaptopSlno(associatePersonal.getCgLaptopSlno());
			ap.setDbsLaptopSlno(associatePersonal.getDbsLaptopSlno());
			ap.setDateOfLaptopTaken(associatePersonal.getDateOfLaptopTaken());
			ap.setDateOfLaptopReturn(associatePersonal.getDateOfLaptopReturn());
			ap.setSpoc(associatePersonal.getSpoc());

			return new ResponseEntity<AssociatePersonal>(associateService.updateAssociate(ap),HttpStatus.OK);
		}
		catch (AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/upload-pancard/{cgGroupId}")
    public String UploadFile(@RequestPart("file") MultipartFile file, @PathVariable Integer cgGroupId)
	{
		try{
			boolean isUpload=associateService.uploadFile(file,cgGroupId);
			if(isUpload) {
				String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("dbsoApp/file/download-pancard/" + cgGroupId).toUriString();
				return fileDownloadUri;
			}
			else
				return "Colud not upload file!";
		}
		catch(AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	@GetMapping("/file/download-pancard/{cgGroupId}")
	public ResponseEntity downloadFromDB(@PathVariable Integer cgGroupId) {
		try {
			String fileName=associateService.getFileNameById(cgGroupId);
			String type=URLConnection.guessContentTypeFromName(fileName);
			byte[] file=associateService.getFileById(cgGroupId);
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(type))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+fileName+"\"")
					.body(file);
		}catch(AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@PutMapping("/uploadfile1/{cgGroupId}")
    public String UploadFile1(@RequestPart("file") MultipartFile file1, @PathVariable Integer cgGroupId)
	{
		try{
			boolean isUpload=associateService.uploadFile1(file1,cgGroupId);
			if(isUpload) {
				String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("dbsoApp/file1/download1/" + cgGroupId).toUriString();
				return fileDownloadUri;
			}
			else
				return "Colud not upload file!";
		}
		catch(AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@GetMapping("/file1/download1/{cgGroupId}")
	public ResponseEntity downloadFromDB1(@PathVariable Integer cgGroupId) {
		try {
			String fileName1=associateService.getFileNameById1(cgGroupId);
			String type=URLConnection.guessContentTypeFromName(fileName1);
			byte[] file=associateService.getFileById1(cgGroupId);
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(type))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+fileName1+"\"")
					.body(file);
		}catch(AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@PutMapping("/upload-cv/{cgGroupId}")
    public String UploadCv(@RequestPart("file") MultipartFile cvr, @PathVariable Integer cgGroupId)
	{
		try{
			boolean isUpload=associateService.uploadCv(cvr,cgGroupId);
			if(isUpload) {
				String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("dbsoApp/cvr/downloadCv/" + cgGroupId).toUriString();
				return fileDownloadUri;
			}
			else
				return "Colud not upload file!";
		}
		catch(AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@GetMapping("/cvr/downloadCv/{cgGroupId}")
	public ResponseEntity downloadFromCv1(@PathVariable Integer cgGroupId) {
		try {
			String cvresume=associateService.getFileNameById2(cgGroupId);
			String type=URLConnection.guessContentTypeFromName(cvresume);
			byte[] file=associateService.getFileById2(cgGroupId);
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(type))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+cvresume+"\"")
					.body(file);
		}catch(AssociateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}

