package com.wgu.banner.model;


public class StudentAdmissionDecisionRequest {
	
	private Integer studentAdmissionDecisionPIDM;      // Primary Key PIDM
	private String studentAdmissionDecisionTermCode;   // Primary Key New Term Code
	private String studentAdmissionDecisionApdcCode;   // Application Decision Code for the Term -- set to '40' for New Term
	
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
	public String getStudentAdmissionDecisionApdcCode() {
		return studentAdmissionDecisionApdcCode;
	}
	public void setStudentAdmissionDecisionApdcCode(String studentAdmissionDecisionApdcCode) {
		this.studentAdmissionDecisionApdcCode = studentAdmissionDecisionApdcCode;
	}
	
	@Override
	public String toString() {
		return "ApplicationDecisionRequest [studentAdmissionDecisionPIDM=" + studentAdmissionDecisionPIDM
				+ ", studentAdmissionDecisionTermCode=" + studentAdmissionDecisionTermCode
				+ ", studentAdmissionDecisionApdcCode=" + studentAdmissionDecisionApdcCode + "]";
	}
	
}
