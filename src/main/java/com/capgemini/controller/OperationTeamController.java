package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.math3.geometry.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.AssociateProf;
import com.capgemini.exception.AssociateException;
import com.capgemini.exception.OperationException;
import com.capgemini.service.OperationService;
import com.capgemini.util.ExcelGenerator;

import lombok.extern.slf4j.Slf4j;

import com.capgemini.service.OperationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/dbsoApp")
@Slf4j
public class OperationTeamController {

	@Autowired
	private OperationService operationService;

	//add associate professional details
	//localhost:8080/dbsoApp/add-associate-professional/456474
	@PostMapping("/add-associate-professional/{cgGroupId}")
	public Integer addAssociateProfDetails(@PathVariable Integer cgGroupId,  @RequestBody AssociateProf associateProf) {
		try {
			Integer status=operationService.addAssociateProfDetails(cgGroupId,associateProf);
			return status;	
		} catch (OperationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	} 

	//update associate
	//localhost:8080/dbsoApp/update/1
	@PutMapping("/updateProfessional/{sNo}")
	public ResponseEntity<AssociateProf> updateAssociateProfDetails(@PathVariable Integer sNo,
			@RequestBody AssociateProf associateProf){
		try {
			AssociateProf ap=operationService.getAssociateProfById(sNo);
			ap.setResourceStatus(associateProf.getResourceStatus());
			ap.setBillability(associateProf.getBillability());
			ap.setCurrency(associateProf.getCurrency());
			ap.setLwdAccount(associateProf.getLwdAccount());
			ap.setLwdReason(associateProf.getLwdReason());
			ap.setPesStatus(associateProf.getPesStatus());
			ap.setBillRate(associateProf.getBillRate());
			ap.setSowStart(associateProf.getSowStart());
			ap.setSowEnd(associateProf.getSowEnd());
			ap.setPoNumbers(associateProf.getPoNumbers());
			ap.setComments(associateProf.getComments());

			return new ResponseEntity<AssociateProf>(operationService.updateAssociateProfDetails(ap),
					HttpStatus.OK);
		}
		catch (OperationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//get all
	//localhost:8080/dbsoApp/get-professional-details
	@GetMapping("/get-professional-details")
	public ResponseEntity<List<AssociateProf>> getAllAssociateProfessionalDetails(){
		try {
			List<AssociateProf> associateProfList=operationService.getAllAssociateProfDetails();
			return new ResponseEntity<>(associateProfList,HttpStatus.OK);
		}
		catch (OperationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//get associatre professional by id
	//localhost:8080/dbsoApp/get-professional-by-id/1
	@GetMapping("/get-professional-by-id/{sNo}")
	public ResponseEntity<AssociateProf> getAssociateProfessionalDetailsById(@PathVariable Integer sNo){
		try {
			AssociateProf associateProf=operationService.getAssociateProfById(sNo);
			return new ResponseEntity<>(associateProf,HttpStatus.OK);
		}
		catch (OperationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	//get all
	//localhost:8080/dbsoApp/generateReport
	@GetMapping("/generateReport")
	public ResponseEntity<InputStreamResource> generateReport() throws IOException {
		List<AssociateProf> associateProfList;
		try {
			associateProfList = operationService.getAllAssociateProfDetails();
			ByteArrayInputStream in = ExcelGenerator.customersToExcel(associateProfList);
			// return IOUtils.toByteArray(in);
			
			HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=asociate_details.xlsx");
			
			 return ResponseEntity
		                .ok()
		                .headers(headers)
		                .body(new InputStreamResource(in));
		} catch (OperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}	
	}
}

