package com.gs.demo.model;

public class StudentGeneralAcademicRequest {

	private String generalAcademicTermCodeEFF; // Primary Key New Term Code
	private String generalAcademicStatus;      // Student status for New Term need to set 'AS'
	private Integer generalAcademicPIDM;       // Primary Key PIDM
	private String generalAcademicType;        // Student type for New Term need to set 'G'
	private String curriculaCodeCtlg;              // Catalog Term Code for Learner Curriculum
	private String curriculaProgramCode;           // Program of Curriculum
	private String curriculaCampCode;              // Campus Code of Curriculum
	private String curriculaLevlCode;              // Graduate Level of Student Application 'UG' or 'GR'
	private String curriculaCollCode;              // College code of the curriculum
	private String curriculaDegcCode;              // Degree code of the curriculum
	private String curriculaLmodCode;              // Learner Module code 'LEARNER' for SGASTDN, 'ADMISSIONS' for SAAADMS
	
	public String getGeneralAcademicTermCodeEFF() {
		return generalAcademicTermCodeEFF;
	}
	public void setGeneralAcademicTermCodeEFF(String generalAcademicTermCodeEFF) {
		this.generalAcademicTermCodeEFF = generalAcademicTermCodeEFF;
	}
	public String getGeneralAcademicStatus() {
		return generalAcademicStatus;
	}
	public void setGeneralAcademicStatus(String generalAcademicStatus) {
		this.generalAcademicStatus = generalAcademicStatus;
	}
	public Integer getGeneralAcademicPIDM() {
		return generalAcademicPIDM;
	}
	public void setGeneralAcademicPIDM(Integer generalAcademicPIDM) {
		this.generalAcademicPIDM = generalAcademicPIDM;
	}
	public String getGeneralAcademicType() {
		return generalAcademicType;
	}
	public void setGeneralAcademicType(String generalAcademicType) {
		this.generalAcademicType = generalAcademicType;
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
	
	@Override
	public String toString() {
		return "StudentGeneralAcademicRequest [generalAcademicTermCodeEFF=" + generalAcademicTermCodeEFF
				+ ", generalAcademicStatus=" + generalAcademicStatus + ", generalAcademicPIDM=" + generalAcademicPIDM
				+ ", generalAcademicType=" + generalAcademicType + ", curriculaCodeCtlg=" + curriculaCodeCtlg
				+ ", curriculaProgramCode=" + curriculaProgramCode + ", curriculaCampCode=" + curriculaCampCode
				+ ", curriculaLevlCode=" + curriculaLevlCode + ", curriculaCollCode=" + curriculaCollCode
				+ ", curriculaDegcCode=" + curriculaDegcCode + ", curriculaLmodCode=" + curriculaLmodCode + "]";
	}
	
}
