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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OperationTeam")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column( name = "S.no")
	private Integer sno;

	@OneToOne
	@JoinColumn
	@Column( name="cg_group_Id")
	private Integer cgGroupId;

	@Column( name = "Resource_Status")
	private String resourceStatus;

	@Column( name = "Billability")
	private String billability;

	@Column( name = "Currency")
	private String currency;

	@Column( name = "LWD_Account")
	private Date LWDAccount;

	@Column( name = "LWD_Reason")
	private String LWDReason;

	@Column( name = "PES_Status")
	private String PESStatus;

	@Column( name = "Bill_rate")
	private Integer billRate;

	@Column( name = "SOW_start")
	private Date SOWStart;

	@Column( name = "SOW_end")
	private Date SOWEnd;

	@Column( name = "PO_Numbers")
	private String PONumbers;

	@Column( name = "Comments_for_PMO_Team")
	private String comments;

}