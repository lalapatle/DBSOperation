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

	public AssociateProf(Integer sNo, String resourceStatus, String billability, String currency, Date lwdAccount,
			String lwdReason, String pesStatus, Integer billRate, Date sowStart, Date sowEnd, String poNumbers,
			String comments, AssociatePersonal associatePersonal) {
		super();
		this.sNo = sNo;
		this.resourceStatus = resourceStatus;
		this.billability = billability;
		this.currency = currency;
		this.lwdAccount = lwdAccount;
		this.lwdReason = lwdReason;
		this.pesStatus = pesStatus;
		this.billRate = billRate;
		this.sowStart = sowStart;
		this.sowEnd = sowEnd;
		this.poNumbers = poNumbers;
		this.comments = comments;
		this.associatePersonal = associatePersonal;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public String getBillability() {
		return billability;
	}

	public void setBillability(String billability) {
		this.billability = billability;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getLwdAccount() {
		return lwdAccount;
	}

	public void setLwdAccount(Date lwdAccount) {
		this.lwdAccount = lwdAccount;
	}

	public String getLwdReason() {
		return lwdReason;
	}

	public void setLwdReason(String lwdReason) {
		this.lwdReason = lwdReason;
	}

	public String getPesStatus() {
		return pesStatus;
	}

	public void setPesStatus(String pesStatus) {
		this.pesStatus = pesStatus;
	}

	public Integer getBillRate() {
		return billRate;
	}

	public void setBillRate(Integer billRate) {
		this.billRate = billRate;
	}

	public Date getSowStart() {
		return sowStart;
	}

	public void setSowStart(Date sowStart) {
		this.sowStart = sowStart;
	}

	public Date getSowEnd() {
		return sowEnd;
	}

	public void setSowEnd(Date sowEnd) {
		this.sowEnd = sowEnd;
	}

	public String getPoNumbers() {
		return poNumbers;
	}

	public void setPoNumbers(String poNumbers) {
		this.poNumbers = poNumbers;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public AssociatePersonal getAssociatePersonal() {
		return associatePersonal;
	}

	public void setAssociatePersonal(AssociatePersonal associatePersonal) {
		this.associatePersonal = associatePersonal;
	}

	
}