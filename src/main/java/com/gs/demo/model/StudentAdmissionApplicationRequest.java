package com.gs.demo.model;

public class StudentAdmissionApplicationRequest {  // SARADAP table
	
	private Integer admissionApplicationPIDM;      // Primary Key PIDM
	private String admissionApplicationTermCode;   // Primary Key New Term Code
	private String admissionApplicationStypCode;   // Type of student Applicant will become, need to set to 'G' for New First Term
	private String curriculaCodeCtlg;              // Catalog Term Code for Learner Curriculum
	private String curriculaProgramCode;           // Program of Curriculum
	private String curriculaCampCode;              // Campus Code of Curriculum
	private String curriculaLevlCode;              // Graduate Level of Student Application 'UG' or 'GR'
	private String curriculaCollCode;              // College code of the curriculum
	private String curriculaDegcCode;              // Degree code of the curriculum
	private String curriculaLmodCode;              // Learner Module code 'LEARNER' for SGASTDN, 'ADMISSIONS' for SAAADMS

	public Integer getAdmissionApplicationPIDM() {
		return admissionApplicationPIDM;
	}
	public void setAdmissionApplicationPIDM(Integer admissionApplicationPIDM) {
		this.admissionApplicationPIDM = admissionApplicationPIDM;
	}
	public String getAdmissionApplicationTermCode() {
		return admissionApplicationTermCode;
	}
	public void setAdmissionApplicationTermCode(String admissionApplicationTermCode) {
		this.admissionApplicationTermCode = admissionApplicationTermCode;
	}
	public String getAdmissionApplicationStypCode() {
		return admissionApplicationStypCode;
	}
	public void setAdmissionApplicationStypCode(String admissionApplicationStypCode) {
		this.admissionApplicationStypCode = admissionApplicationStypCode;
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
		return "AdmissionApplicationRequest [admissionApplicationPIDM=" + admissionApplicationPIDM
				+ ", admissionApplicationTermCode=" + admissionApplicationTermCode + ", admissionApplicationStypCode="
				+ admissionApplicationStypCode + ", curriculaCodeCtlg=" + curriculaCodeCtlg + ", curriculaProgramCode="
				+ curriculaProgramCode + ", curriculaCampCode=" + curriculaCampCode + ", curriculaLevlCode="
				+ curriculaLevlCode + ", curriculaCollCode=" + curriculaCollCode + ", curriculaDegcCode="
				+ curriculaDegcCode + ", curriculaLmodCode=" + curriculaLmodCode + "]";
	}
	
}
