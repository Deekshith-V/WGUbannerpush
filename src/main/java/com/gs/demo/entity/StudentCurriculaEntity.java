package com.gs.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sorlcur", schema = "saturn")  // SGASTDN and SAAADMS banner forms 
@IdClass(StudentCurriculaEntityKey.class)    // --> SORLCUR table in banner Oracle for Curricula tab/section for both forms
public class StudentCurriculaEntity {

	@Id
	@Column(name = "SORLCUR_PIDM")           // Primary Key PIDM
	private Integer curriculaPIDM;
	
	@Id
	@Column(name = "SORLCUR_SEQNO")          // Primary Key Sequence Number
	private Integer curriculaSeqNo;

	@Column(name = "SORLCUR_LMOD_CODE")      // Learner Module code 'LEARNER' for SGASTDN, 'ADMISSIONS' for SAAADMS
	private String curriculaLmodCode;

	@Column(name = "SORLCUR_TERM_CODE_CTLG") // Catalog Term Code for Learner Curriculum
	private String curriculaCodeCTLG;

	@Column(name = "SORLCUR_PRIORITY_NO")    // Priority of Curriculum with Module
	private Integer curriculaPriorityNo;
	
	@Column(name = "SORLCUR_PROGRAM")        // Program of Curriculum
	private String curriculaProgram;

	@Column(name = "SORLCUR_CAMP_CODE")      // Campus Code of Curriculum
	private String curriculaCampCode;
	
	@Column(name = "SORLCUR_TERM_CODE")      // New Term Code
	private String curriculaTermCode;

	@Column(name = "SORLCUR_KEY_SEQNO")      // Sequence Number of Key Record
	private Integer curriculaKeySeqno;

	@Column(name = "SORLCUR_ROLL_IND")       // Y/N indicator if learner curriculum should roll to academic history
	private String curriculaRollind;

	@Column(name = "SORLCUR_CACT_CODE")      // Activity Status Code for the curriculum
	private String curriculaCactCode;
	
	@Column(name = "SORLCUR_USER_ID")        // Most recent User to create or update record.
	private String curriculaUserId;
	
	@Column(name = "SORLCUR_DATA_ORIGIN")    // Source system that generated the data
	private String curriculaDataOrgin;
	
	@Column(name = "SORLCUR_ACTIVITY_DATE")  // Date the current record was created or updated
	private Timestamp curriculaActivityDate;
	
	@Column(name = "SORLCUR_LEVL_CODE")      // Graduate Level of Student Application 'UG' or 'GR'
	private String curriculaLevlCode;

	@Column(name = "SORLCUR_COLL_CODE")      // College code of the curriculum
	private String curriculaCollCode;
	
	@Column(name = "SORLCUR_DEGC_CODE")      // Degree code of the curriculum
	private String curriculaDegCode;
	
//	@Column(name = "SORLCUR_SURROGATE_ID")   // Immutable unique key
//	private String curriculesurgID;
//	
//	@Column(name = "SORLCUR_VERSION")        // Optimistic Lock Token
//	private String curriculeVersion;
	
	@Column(name = "SORLCUR_CURRENT_CDE")    // Current Indicator of the Curriculum
	private String curriculaCurrentCDE;

	public Integer getCurriculaPIDM() {
		return curriculaPIDM;
	}

	public String getCurriculaTermCode() {
		return curriculaTermCode;
	}

	public void setCurriculaPIDM(Integer curriculaPIDM) {
		this.curriculaPIDM = curriculaPIDM;
	}

	public String getCurriculaLmodCode() {
		return curriculaLmodCode;
	}

	public void setCurriculaLmodCode(String curriculaLmodCode) {
		this.curriculaLmodCode = curriculaLmodCode;
	}

	public String getCurriculaCodeCTLG() {
		return curriculaCodeCTLG;
	}

	public void setCurriculaCodeCTLG(String curriculaCodeCTLG) {
		this.curriculaCodeCTLG = curriculaCodeCTLG;
	}

	public Integer getCurriculaPriorityNo() {
		return curriculaPriorityNo;
	}

	public void setCurriculaPriorityNo(Integer curriculaPriorityNo) {
		this.curriculaPriorityNo = curriculaPriorityNo;
	}

	public String getCurriculaProgram() {
		return curriculaProgram;
	}

	public void setCurriculaProgram(String curriculaProgram) {
		this.curriculaProgram = curriculaProgram;
	}

	public String getCurriculaCampCode() {
		return curriculaCampCode;
	}

	public void setCurriculaCampCode(String curriculaCampCode) {
		this.curriculaCampCode = curriculaCampCode;
	}

	public Integer getCurriculaKeySeqno() {
		return curriculaKeySeqno;
	}

	public void setCurriculaKeySeqno(Integer curriculaKeySeqno) {
		this.curriculaKeySeqno = curriculaKeySeqno;
	}

	public String getCurriculaRollind() {
		return curriculaRollind;
	}

	public void setCurriculaRollind(String curriculaRollind) {
		this.curriculaRollind = curriculaRollind;
	}

	public String getCurriculaCactCode() {
		return curriculaCactCode;
	}

	public void setCurriculaCactCode(String curriculaCactCode) {
		this.curriculaCactCode = curriculaCactCode;
	}

	public String getCurriculaUserId() {
		return curriculaUserId;
	}

	public void setCurriculaUserId(String curriculaUserId) {
		this.curriculaUserId = curriculaUserId;
	}

	public String getCurriculaDataOrgin() {
		return curriculaDataOrgin;
	}

	public void setCurriculaDataOrgin(String curriculaDataOrgin) {
		this.curriculaDataOrgin = curriculaDataOrgin;
	}

	public Timestamp getCurriculaActivityDate() {
		return curriculaActivityDate;
	}

	public void setCurriculaActivityDate(Timestamp curriculaActivityDate) {
		this.curriculaActivityDate = curriculaActivityDate;
	}

	public String getCurriculaLevlCode() {
		return curriculaLevlCode;
	}

	public void setCurriculaLevlCode(String curriculaLevlCode) {
		this.curriculaLevlCode = curriculaLevlCode;
	}

	public String getCurriculaCollCode() {
		return curriculaCollCode;
	}

	public void setCurriculaCollCode(String curriculaCollCode) {
		this.curriculaCollCode = curriculaCollCode;
	}

	public String getCurriculaDegCode() {
		return curriculaDegCode;
	}

	public void setCurriculaDegCode(String curriculaDegCode) {
		this.curriculaDegCode = curriculaDegCode;
	}

	public void setCurriculaTermCode(String curriculaTermCode) {
		this.curriculaTermCode = curriculaTermCode;
	}

//	public String getCurriculesurgID() {
//		return curriculesurgID;
//	}
//
//	public void setCurriculesurgID(String curriculesurgID) {
//		this.curriculesurgID = curriculesurgID;
//	}
//
//	public String getCurriculeVersion() {
//		return curriculeVersion;
//	}
//
//	public void setCurriculeVersion(String curriculeVersion) {
//		this.curriculeVersion = curriculeVersion;
//	}

	public Integer getCurriculaSeqNo() {
		return curriculaSeqNo;
	}

	public void setCurriculaSeqNo(Integer curriculaSeqNo) {
		this.curriculaSeqNo = curriculaSeqNo;
	}

	public String getCurriculaCurrentCDE() {
		return curriculaCurrentCDE;
	}

	public void setCurriculaCurrentCDE(String curriculaCurrentCDE) {
		this.curriculaCurrentCDE = curriculaCurrentCDE;
	}
		
}
