package com.capgemini.entity;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "associate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Associate {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
@Column( name = "CG_Group_Id")
private Integer cgGroupId;

@Column( name = "CG_Group_Id")
private String associateFullName;

private String gender;
private String cgUserName;
private String cgMailId;
private String region;
private String practice;
private String designation;
private String cgSupervisor;
private String cgDBSAccountSupervisor;
private String DBSClientLead;
private String tower;
private String shortTower;
private String reasonResignation;
private String associateLocation;
private Date dateOfJoiningDBSAccount;
private Date DBSBillableStartDate;
private String bankId;
private String DBSMailId;
@Column(name="primary_skill")
private String primarySkill;
@Column(name="overall_experience_before_cg")
private String overallExperienceBeforeJoiningCgString;
@Column(name="sow_number")
private String SOWNumber;
@Column(name="mandatory_training")
private String mandatoryTraining;
@Column(name="onboarding_docs")
private String OnboardingDocs;
@Column(name="pancard")
private String panCard;
@Column(name="passport")
private String passport;
@Column(name="passport_expiry_date")
private Date passportExpiryDate;
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
private String CSBForm;
@Column(name="cg_laptop_sl_no")
private String cgLaptopSlno;
@Column(name="dbs_laptop_sl_no")
private String DBSLaptopSlno;
@Column(name="date_of_laptop_taken")
private Date dateOfLaptopTaken;
@Column(name="date_of_laptop_return")
private Date dateOfLaptopReturn;
@Column(name="spoc")
private String SPOC;

















}