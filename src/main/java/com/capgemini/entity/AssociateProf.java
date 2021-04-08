package com.capgemini.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AssociateProf")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociateProf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo; 
	
	@Column( name = "Resource_Status")
	private String resourceStatus;

	@Column( name = "Billability")
	private String billability;

	@Column( name = "Currency")
	private String currency;

	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column( name = "LWD_Account")
	private Date lwdAccount;

	@Column( name = "LWD_Reason")
	private String lwdReason;

	@Column( name = "PES_Status")
	private String pesStatus;

	@Column( name = "Bill_rate")
	private Integer billRate;

	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column( name = "SOW_start")
	private Date sowStart;
	
	@JsonFormat(pattern="dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
	@Column( name = "SOW_end")
	private Date sowEnd;

	@Column( name = "PO_Numbers")
	private String poNumbers;

	@Column( name = "Comments_for_PMO_Team")
	private String comments;
	
	@OneToOne
	@JoinColumn( name="cg_group_Id")
	private AssociatePersonal associatePersonal;

	}