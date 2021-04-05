package com.capgemini.entity;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "associate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociatePersonal {

	@Id
	@Column( name = "cg_group_Id")
	private Integer cgGroupId;
	
	@Column( name = "associate_full_name")
	private String associateFullName;
	
	@Column( name = "gender")
	private String gender;
	
	@Column( name = "cg_user_name")
	private String cgUserName;
	
	@Column( name = "cg_mail_Id")
	private String cgMailId;
	
	@Column( name = "region")
	private String region;
	
	@Column( name = "practice")
	private String practice;
	
	@Column( name = "designation")
	private String designation;
	
	@Column( name = "cg_supervisor")
	private String cgSupervisor;
	
	@Column( name = "cg_dbs_account_supervisor")
	private String cgDBSAccountSupervisor;
	
	@Column( name = "dbs_client_lead")
	private String dbsClientLead;
	
	@Column( name = "tower")
	private String tower;
	
	@Column( name = "short_tower")
	private String shortTower;
	
	@Column( name = "reason_resignation")
	private String reasonResignation;
	
	@Column( name = "associate_location")
	private String associateLocation;
	
	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column( name = "Date_of_joining_dbs_account")
	private Date dateOfJoiningDBSAccount;
	
	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column( name = "dbs_billable_start_date")
	private Date dbsBillableStartDate;
	
	@Column( name = "bank_Id")
	private String bankId;
	
	@Column( name = "dbs_mail_Id")
	private String dbsMailId;
	
	@Column(name="primary_skill")
	private String primarySkill;
	
	@Column(name="overall_experience_before_cg")
	private String overallExperienceBeforeJoiningCg;
	
	@Column(name="sow_number")
	private String sowNumber;
	
	@Column(name="mandatory_training")
	private String mandatoryTraining;
	
	@Column(name="onboarding_docs")
	private String onboardingDocs;
	
	@Column(name="pancard")
	private String panCard;
	
	@Column(name="passport")
	private String passport;
	
	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column(name="passport_expiry_date")
	private Date passportExpiryDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="foreign_employment_experience")
	private String foreignEmploymentExperience;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="emergency_contact")
	private String emergencyContact;
	
	@Column(name="temporary_address")
	private String temporaryAddress;
	
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Column(name="CSB_form")
	private String csbForm;
	
	@Column(name="cg_laptop_sl_no")
	private String cgLaptopSlno;
	
	@Column(name="dbs_laptop_sl_no")
	private String dbsLaptopSlno;
	
	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column(name="date_of_laptop_taken")
	private Date dateOfLaptopTaken;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_laptop_return")
	private Date dateOfLaptopReturn;
	
	@Column(name="spoc")
	private String spoc;

	public AssociatePersonal(Integer cgGroupId, String associateFullName, String gender, String cgUserName,
			String cgMailId, String region, String practice, String designation, String cgSupervisor,
			String cgDBSAccountSupervisor, String dbsClientLead, String tower, String shortTower,
			String reasonResignation, String associateLocation, Date dateOfJoiningDBSAccount, Date dbsBillableStartDate,
			String bankId, String dbsMailId, String primarySkill, String overallExperienceBeforeJoiningCg,
			String sowNumber, String mandatoryTraining, String onboardingDocs, String panCard, String passport,
			Date passportExpiryDate, Date dateOfBirth, String foreignEmploymentExperience, String contact,
			String emergencyContact, String temporaryAddress, String permanentAddress, String csbForm,
			String cgLaptopSlno, String dbsLaptopSlno, Date dateOfLaptopTaken, Date dateOfLaptopReturn, String spoc) {
		super();
		this.cgGroupId = cgGroupId;
		this.associateFullName = associateFullName;
		this.gender = gender;
		this.cgUserName = cgUserName;
		this.cgMailId = cgMailId;
		this.region = region;
		this.practice = practice;
		this.designation = designation;
		this.cgSupervisor = cgSupervisor;
		this.cgDBSAccountSupervisor = cgDBSAccountSupervisor;
		this.dbsClientLead = dbsClientLead;
		this.tower = tower;
		this.shortTower = shortTower;
		this.reasonResignation = reasonResignation;
		this.associateLocation = associateLocation;
		this.dateOfJoiningDBSAccount = dateOfJoiningDBSAccount;
		this.dbsBillableStartDate = dbsBillableStartDate;
		this.bankId = bankId;
		this.dbsMailId = dbsMailId;
		this.primarySkill = primarySkill;
		this.overallExperienceBeforeJoiningCg = overallExperienceBeforeJoiningCg;
		this.sowNumber = sowNumber;
		this.mandatoryTraining = mandatoryTraining;
		this.onboardingDocs = onboardingDocs;
		this.panCard = panCard;
		this.passport = passport;
		this.passportExpiryDate = passportExpiryDate;
		this.dateOfBirth = dateOfBirth;
		this.foreignEmploymentExperience = foreignEmploymentExperience;
		this.contact = contact;
		this.emergencyContact = emergencyContact;
		this.temporaryAddress = temporaryAddress;
		this.permanentAddress = permanentAddress;
		this.csbForm = csbForm;
		this.cgLaptopSlno = cgLaptopSlno;
		this.dbsLaptopSlno = dbsLaptopSlno;
		this.dateOfLaptopTaken = dateOfLaptopTaken;
		this.dateOfLaptopReturn = dateOfLaptopReturn;
		this.spoc = spoc;
	}

	public Integer getCgGroupId() {
		return cgGroupId;
	}

	public void setCgGroupId(Integer cgGroupId) {
		this.cgGroupId = cgGroupId;
	}

	public String getAssociateFullName() {
		return associateFullName;
	}

	public void setAssociateFullName(String associateFullName) {
		this.associateFullName = associateFullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCgUserName() {
		return cgUserName;
	}

	public void setCgUserName(String cgUserName) {
		this.cgUserName = cgUserName;
	}

	public String getCgMailId() {
		return cgMailId;
	}

	public void setCgMailId(String cgMailId) {
		this.cgMailId = cgMailId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCgSupervisor() {
		return cgSupervisor;
	}

	public void setCgSupervisor(String cgSupervisor) {
		this.cgSupervisor = cgSupervisor;
	}

	public String getCgDBSAccountSupervisor() {
		return cgDBSAccountSupervisor;
	}

	public void setCgDBSAccountSupervisor(String cgDBSAccountSupervisor) {
		this.cgDBSAccountSupervisor = cgDBSAccountSupervisor;
	}

	public String getDbsClientLead() {
		return dbsClientLead;
	}

	public void setDbsClientLead(String dbsClientLead) {
		this.dbsClientLead = dbsClientLead;
	}

	public String getTower() {
		return tower;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}

	public String getShortTower() {
		return shortTower;
	}

	public void setShortTower(String shortTower) {
		this.shortTower = shortTower;
	}

	public String getReasonResignation() {
		return reasonResignation;
	}

	public void setReasonResignation(String reasonResignation) {
		this.reasonResignation = reasonResignation;
	}

	public String getAssociateLocation() {
		return associateLocation;
	}

	public void setAssociateLocation(String associateLocation) {
		this.associateLocation = associateLocation;
	}

	public Date getDateOfJoiningDBSAccount() {
		return dateOfJoiningDBSAccount;
	}

	public void setDateOfJoiningDBSAccount(Date dateOfJoiningDBSAccount) {
		this.dateOfJoiningDBSAccount = dateOfJoiningDBSAccount;
	}

	public Date getDbsBillableStartDate() {
		return dbsBillableStartDate;
	}

	public void setDbsBillableStartDate(Date dbsBillableStartDate) {
		this.dbsBillableStartDate = dbsBillableStartDate;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getDbsMailId() {
		return dbsMailId;
	}

	public void setDbsMailId(String dbsMailId) {
		this.dbsMailId = dbsMailId;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getOverallExperienceBeforeJoiningCg() {
		return overallExperienceBeforeJoiningCg;
	}

	public void setOverallExperienceBeforeJoiningCg(String overallExperienceBeforeJoiningCg) {
		this.overallExperienceBeforeJoiningCg = overallExperienceBeforeJoiningCg;
	}

	public String getSowNumber() {
		return sowNumber;
	}

	public void setSowNumber(String sowNumber) {
		this.sowNumber = sowNumber;
	}

	public String getMandatoryTraining() {
		return mandatoryTraining;
	}

	public void setMandatoryTraining(String mandatoryTraining) {
		this.mandatoryTraining = mandatoryTraining;
	}

	public String getOnboardingDocs() {
		return onboardingDocs;
	}

	public void setOnboardingDocs(String onboardingDocs) {
		this.onboardingDocs = onboardingDocs;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Date getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getForeignEmploymentExperience() {
		return foreignEmploymentExperience;
	}

	public void setForeignEmploymentExperience(String foreignEmploymentExperience) {
		this.foreignEmploymentExperience = foreignEmploymentExperience;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCsbForm() {
		return csbForm;
	}

	public void setCsbForm(String csbForm) {
		this.csbForm = csbForm;
	}

	public String getCgLaptopSlno() {
		return cgLaptopSlno;
	}

	public void setCgLaptopSlno(String cgLaptopSlno) {
		this.cgLaptopSlno = cgLaptopSlno;
	}

	public String getDbsLaptopSlno() {
		return dbsLaptopSlno;
	}

	public void setDbsLaptopSlno(String dbsLaptopSlno) {
		this.dbsLaptopSlno = dbsLaptopSlno;
	}

	public Date getDateOfLaptopTaken() {
		return dateOfLaptopTaken;
	}

	public void setDateOfLaptopTaken(Date dateOfLaptopTaken) {
		this.dateOfLaptopTaken = dateOfLaptopTaken;
	}

	public Date getDateOfLaptopReturn() {
		return dateOfLaptopReturn;
	}

	public void setDateOfLaptopReturn(Date dateOfLaptopReturn) {
		this.dateOfLaptopReturn = dateOfLaptopReturn;
	}

	public String getSpoc() {
		return spoc;
	}

	public void setSpoc(String spoc) {
		this.spoc = spoc;
	}
	
	
}












