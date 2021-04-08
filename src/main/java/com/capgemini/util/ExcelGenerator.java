package com.capgemini.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.capgemini.entity.AssociateProf;

public class ExcelGenerator {
	public static ByteArrayInputStream customersToExcel(List<AssociateProf> associateProf) throws IOException {
		String[] COLUMNs = {"S.no",	"CG Group ID","Associate_Full_Name","Gender (M/F)","CG User name","CG Mail ID","Region","Entity/Practice","Designation","CG-Supervisor","CG-DBS account-Supervisor","DBS client Lead","Tower","Short Tower","Resource Status- Onboarded/In-progress","Billability (Billable/Buffer)","Currency (SGD/INR)","LWD- Account/CG","Reason- (Roll-off/Resignation)","LWD reason-Justification","Associate  Location(CAPG ODC/DAH2)","Date of Joining DBS Account","DBS Billable Start date","PES Status","1BankID","DBS Mail ID","Primary Skill","Overall Experience before joining CG in months","Bill rate","SOW Number/Beeline Assignment ID","SOW Start","SOW End","PO Numbers","Comments - For PMO team","Mandatory training","Onbaording docs- funcionality should as such to attach the DBS onbaording docs","Pan Card","Passport","Passport expiry date","Date of Birth - DD-MM-YYYY","Any foreign Employment in last 3 years- if yes specify Country and Duration","Contact","Emergency Contact","Temprary Address- Full","Permanent Address Full","CBS form(Applicable to Onsite only) - funcionality should as such to attach the CBS form","CG Laptop Slno","DBS Laptop Slno","Date of laptop taken/assigned","Date of laptop return","SPOC to whom laptop was returned"};

		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("Associate");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.RED.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	 
			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	 
			int rowIdx = 1;
			for (AssociateProf associateProf2 : associateProf) {
				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(rowIdx-1);
				row.createCell(1).setCellValue(associateProf2.getAssociatePersonal().getCgGroupId());
				row.createCell(2).setCellValue(associateProf2.getAssociatePersonal().getAssociateFullName());
				row.createCell(3).setCellValue(associateProf2.getAssociatePersonal().getGender());
				row.createCell(4).setCellValue(associateProf2.getAssociatePersonal().getCgUserName());
				row.createCell(5).setCellValue(associateProf2.getAssociatePersonal().getCgMailId());
				row.createCell(6).setCellValue(associateProf2.getAssociatePersonal().getRegion());
				row.createCell(7).setCellValue(associateProf2.getAssociatePersonal().getPractice());
				row.createCell(8).setCellValue(associateProf2.getAssociatePersonal().getDesignation());
				row.createCell(9).setCellValue(associateProf2.getAssociatePersonal().getCgSupervisor());
				row.createCell(10).setCellValue(associateProf2.getAssociatePersonal().getCgDBSAccountSupervisor());
				row.createCell(11).setCellValue(associateProf2.getAssociatePersonal().getDbsClientLead());
				row.createCell(12).setCellValue(associateProf2.getAssociatePersonal().getTower());
				row.createCell(13).setCellValue(associateProf2.getAssociatePersonal().getShortTower());
				row.createCell(14).setCellValue(associateProf2.getResourceStatus());
				row.createCell(15).setCellValue(associateProf2.getBillability());
				row.createCell(16).setCellValue(associateProf2.getCurrency());
				row.createCell(17).setCellValue(associateProf2.getLwdAccount().toString());
				row.createCell(18).setCellValue(associateProf2.getAssociatePersonal().getReasonResignation());
				row.createCell(19).setCellValue(associateProf2.getLwdReason());
				row.createCell(20).setCellValue(associateProf2.getAssociatePersonal().getAssociateLocation());
				row.createCell(21).setCellValue(associateProf2.getAssociatePersonal().getDateOfJoiningDBSAccount().toString());
				row.createCell(22).setCellValue(associateProf2.getAssociatePersonal().getDbsBillableStartDate().toString());
				row.createCell(23).setCellValue(associateProf2.getPesStatus());
				row.createCell(24).setCellValue(associateProf2.getAssociatePersonal().getBankId());
				row.createCell(25).setCellValue(associateProf2.getAssociatePersonal().getDbsMailId());
				row.createCell(26).setCellValue(associateProf2.getAssociatePersonal().getPrimarySkill());
				row.createCell(27).setCellValue(associateProf2.getAssociatePersonal().getOverallExperienceBeforeJoiningCg());
				row.createCell(28).setCellValue(associateProf2.getBillRate());
				row.createCell(29).setCellValue(associateProf2.getAssociatePersonal().getSowNumber());
				row.createCell(30).setCellValue(associateProf2.getSowStart().toString());
				row.createCell(31).setCellValue(associateProf2.getSowEnd().toString());
				row.createCell(32).setCellValue(associateProf2.getPoNumbers());
				row.createCell(33).setCellValue(associateProf2.getComments());
				row.createCell(34).setCellValue(associateProf2.getAssociatePersonal().getMandatoryTraining());
				row.createCell(35).setCellValue(associateProf2.getAssociatePersonal().getOnboardingDocs());
				row.createCell(36).setCellValue(associateProf2.getAssociatePersonal().getPanCard());
				row.createCell(37).setCellValue(associateProf2.getAssociatePersonal().getPassport());
				row.createCell(38).setCellValue(associateProf2.getAssociatePersonal().getPassportExpiryDate().toString());
				row.createCell(39).setCellValue(associateProf2.getAssociatePersonal().getDateOfBirth().toString());
				row.createCell(40).setCellValue(associateProf2.getAssociatePersonal().getForeignEmploymentExperience());
				row.createCell(41).setCellValue(associateProf2.getAssociatePersonal().getContact());
				row.createCell(42).setCellValue(associateProf2.getAssociatePersonal().getEmergencyContact());
				row.createCell(43).setCellValue(associateProf2.getAssociatePersonal().getTemporaryAddress());
				row.createCell(44).setCellValue(associateProf2.getAssociatePersonal().getPermanentAddress());
				row.createCell(45).setCellValue(associateProf2.getAssociatePersonal().getCsbForm());
				row.createCell(46).setCellValue(associateProf2.getAssociatePersonal().getCgLaptopSlno());
				row.createCell(47).setCellValue(associateProf2.getAssociatePersonal().getDbsLaptopSlno());
				row.createCell(48).setCellValue(associateProf2.getAssociatePersonal().getDateOfLaptopTaken().toString());
				row.createCell(49).setCellValue(associateProf2.getAssociatePersonal().getDateOfLaptopReturn().toString());
				row.createCell(50).setCellValue(associateProf2.getAssociatePersonal().getSpoc());
				
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}
