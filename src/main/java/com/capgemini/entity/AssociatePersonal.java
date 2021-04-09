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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy" )
//	@Temporal(TemporalType.DATE)
	@Column( name = "Date_of_joining_dbs_account")
	private Date dateOfJoiningDBSAccount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy" )
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
//	@Temporal(TemporalType.DATE)
	@Column(name="passport_expiry_date")
	private Date passportExpiryDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
//	@Temporal(TemporalType.DATE)
	@Column(name="date_of_laptop_taken")
	private Date dateOfLaptopTaken;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_laptop_return")
	private Date dateOfLaptopReturn;
	
	@Column(name="spoc")
	private String spoc;

















}
