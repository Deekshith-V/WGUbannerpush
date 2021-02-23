package com.wgu.banner.model;

public class StudentCurriculaRequest {      // SORLCUR Table

	private Integer curriculaPIDM;          // Primary Key PIDM
	private String curriculaTermCode;       // New Term Code
	private String curriculaCodeCtlg;       // Catalog Term Code for Learner Curriculum
	private String curriculaProgramCode;    // Program of Curriculum
	private String curriculaCampCode;       // Campus Code of Curriculum
	private String curriculaLevlCode;       // Graduate Level of Student Application 'UG' or 'GR'
	private String curriculaCollCode;       // College code of the curriculum
	private String curriculaDegcCode;       // Degree code of the curriculum
	private String curriculaLmodCode;       // Learner Module code 'LEARNER' for SGASTDN, 'ADMISSIONS' for SAAADMS
	private String curriculaRollInd;        // Y/N indicator if learner curriculum should roll to academic history
	private Integer curriculaSeqNo;         // Primary Key Sequence Number
	private Integer curriculaKeySeqNo;      // Sequence Number of Key record
	
	public Integer getCurriculaKeySeqNo() {
		return curriculaKeySeqNo;
	}

	public void setCurriculaKeySeqNo(Integer curriculaKeySeqNo) {
		this.curriculaKeySeqNo = curriculaKeySeqNo;
	}

	public String getCurriculaRollInd() {
		return curriculaRollInd;
	}

	public void setCurriculaRollInd(String curriculaRollInd) {
		this.curriculaRollInd = curriculaRollInd;
	}

	public Integer getCurriculaPIDM() {
		return curriculaPIDM;
	}

	public void setCurriculaPIDM(Integer curriculaPIDM) {
		this.curriculaPIDM = curriculaPIDM;
	}

	public String getCurriculaTermCode() {
		return curriculaTermCode;
	}

	public void setCurriculaTermCode(String curriculaTermCode) {
		this.curriculaTermCode = curriculaTermCode;
	}

	public String getCurriculaCodeCtlg() {
		return curriculaCodeCtlg;
	}

	public void setCurriculaCodeCtlg(String curriculaCodeCtlg) {
		this.curriculaCodeCtlg = curriculaCodeCtlg;
	}

	public String getCurriculaProgramCode() {
		return curriculaProgramCode;
	}

	public void setCurriculaProgramCode(String curriculaProgramCode) {
		this.curriculaProgramCode = curriculaProgramCode;
	}

	public String getCurriculaCampCode() {
		return curriculaCampCode;
	}

	public void setCurriculaCampCode(String curriculaCampCode) {
		this.curriculaCampCode = curriculaCampCode;
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

	public String getCurriculaDegcCode() {
		return curriculaDegcCode;
	}

	public void setCurriculaDegcCode(String curriculaDegcCode) {
		this.curriculaDegcCode = curriculaDegcCode;
	}

	public String getCurriculaLmodCode() {
		return curriculaLmodCode;
	}

	public void setCurriculaLmodCode(String curriculaLmodCode) {
		this.curriculaLmodCode = curriculaLmodCode;
	}

	public Integer getCurriculaSeqNo() {
		return curriculaSeqNo;
	}

	public void setCurriculaSeqNo(Integer curriculaSeqNo) {
		this.curriculaSeqNo = curriculaSeqNo;
	}
	
	
}
