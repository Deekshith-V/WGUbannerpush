package com.gs.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sarappd", schema = "saturn")           // SAADCRV (Student Admissions Decision) banner form --> SARAPPD table in banner Oracle
@IdClass(StudentAdmissionDecisionEntityKey.class)
public class StudentAdmissionDecisionEntity {

	@Id
	@Column(name = "SARAPPD_PIDM")                    // Primary Key PIDM
	private Integer studentAdmissionDecisionPIDM;
	
	@Id
	@Column(name = "SARAPPD_TERM_CODE_ENTRY")         // Primary Key New Term Code
	private String studentAdmissionDecisionTermCode;
	
	@Id
	@Column(name = "SARAPPD_APPL_NO")                 // Primary Key Application Number for the Term
	private Integer studentAdmissionDecisionApplNo;
	
	@Id
	@Column(name = "SARAPPD_SEQ_NO")                  // Primary Key Sequence Number is internal sequence number for the 'i'th Decision Code
	private Integer studentAdmissionDecisionSeqNo;
	
	@Column(name = "SARAPPD_APDC_DATE")               // Date Application Decision was Effective
	private Timestamp studentAdmissionDecisionApdcDate;
	
	@Column(name = "SARAPPD_APDC_CODE")               // Application Decision Code for the Term -- set to '40' for New Term
	private String studentAdmissionDecisionApdcCode;
	
	@Column(name = "SARAPPD_MAINT_IND")               // Maintenance Indicator for Decision if maintained by User or System 
	private String studentAdmissionDecisionMaintInd;
	
	@Column(name = "SARAPPD_ACTIVITY_DATE")           // Date the current record was created or updated
	private Timestamp studentAdmissionDecisionActivityDate;
	
	@Column(name = "SARAPPD_USER")                    // ID of the most recent user to create or update record
	private String studentAdmissionDecisionUser;

	public Integer getStudentAdmissionDecisionPIDM() {
		return studentAdmissionDecisionPIDM;
	}

	public void setStudentAdmissionDecisionPIDM(Integer studentAdmissionDecisionPIDM) {
		this.studentAdmissionDecisionPIDM = studentAdmissionDecisionPIDM;
	}

	public String getStudentAdmissionDecisionTermCode() {
		return studentAdmissionDecisionTermCode;
	}

	public void setStudentAdmissionDecisionTermCode(String studentAdmissionDecisionTermCode) {
		this.studentAdmissionDecisionTermCode = studentAdmissionDecisionTermCode;
	}

	public Integer getStudentAdmissionDecisionApplNo() {
		return studentAdmissionDecisionApplNo;
	}

	public void setStudentAdmissionDecisionApplNo(Integer studentAdmissionDecisionApplNo) {
		this.studentAdmissionDecisionApplNo = studentAdmissionDecisionApplNo;
	}

	public Integer getStudentAdmissionDecisionSeqNo() {
		return studentAdmissionDecisionSeqNo;
	}

	public void setStudentAdmissionDecisionSeqNo(Integer studentAdmissionDecisionSeqNo) {
		this.studentAdmissionDecisionSeqNo = studentAdmissionDecisionSeqNo;
	}

	public Timestamp getStudentAdmissionDecisionApdcDate() {
		return studentAdmissionDecisionApdcDate;
	}

	public void setStudentAdmissionDecisionApdcDate(Timestamp studentAdmissionDecisionApdcDate) {
		this.studentAdmissionDecisionApdcDate = studentAdmissionDecisionApdcDate;
	}

	public String getStudentAdmissionDecisionMaintInd() {
		return studentAdmissionDecisionMaintInd;
	}

	public void setStudentAdmissionDecisionMaintInd(String studentAdmissionDecisionMaintInd) {
		this.studentAdmissionDecisionMaintInd = studentAdmissionDecisionMaintInd;
	}

	public Timestamp getStudentAdmissionDecisionActivityDate() {
		return studentAdmissionDecisionActivityDate;
	}

	public void setStudentAdmissionDecisionActivityDate(Timestamp studentAdmissionDecisionActivityDate) {
		this.studentAdmissionDecisionActivityDate = studentAdmissionDecisionActivityDate;
	}

	public String getStudentAdmissionDecisionApdcCode() {
		return studentAdmissionDecisionApdcCode;
	}

	public void setStudentAdmissionDecisionApdcCode(String studentAdmissionDecisionApdcCode) {
		this.studentAdmissionDecisionApdcCode = studentAdmissionDecisionApdcCode;
	}

	public String getStudentAdmissionDecisionUser() {
		return studentAdmissionDecisionUser;
	}

	public void setStudentAdmissionDecisionUser(String studentAdmissionDecisionUser) {
		this.studentAdmissionDecisionUser = studentAdmissionDecisionUser;
	}
	
	
	
}
