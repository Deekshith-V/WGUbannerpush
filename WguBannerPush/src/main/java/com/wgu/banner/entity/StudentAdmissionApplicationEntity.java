package com.wgu.banner.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "saradap", schema = "saturn")            // SAAADMS (Student Admissions Application) banner form 
@IdClass(StudentAdmissionApplicationEntityKey.class)   // --> SARADAP table in banner Oracle for Application tab/section
public class StudentAdmissionApplicationEntity {
	
	@Id
	@Column(name = "SARADAP_PIDM")                     // Primary Key PIDM
	private Integer admissionApplicationPIDM;
	
	@Id
	@Column(name = "SARADAP_TERM_CODE_ENTRY")          // Primary Key New Term Code
	private String admissionApplicationTermCodeEntry;
	
	@Id
	@Column(name = "SARADAP_APPL_NO")                  // Primary Key Application Number for the Term
	private Integer admissionApplicationApplNo;
	
	@Column(name = "SARADAP_LEVL_CODE")                // Graduate Level of Student Application 'UG' or 'GR'
	private String admissionApplicationLevlCode;
	
	@Column(name = "SARADAP_APPL_DATE")                // Date of Application Record
	private Timestamp admissionApplicationApplDate;
	
	@Column(name = "SARADAP_APST_CODE")                // Status of the Application 'C' for Complete ready for review
	private String admissionApplicationApstCode;
	
	@Column(name = "SARADAP_APST_DATE")                // Date associated with most current status of application
	private Timestamp admissionApplicationApstDate;
	
	@Column(name = "SARADAP_MAINT_IND")                // Maintenance Indicator for Application if maintained by User or System 
	private String admissionApplicationMaintInd;
	
	@Column(name = "SARADAP_ADMT_CODE")                // Admission type of Applicant set to 'ST' for standard
	private String admissionApplicationAdmtCode;
	
	@Column(name = "SARADAP_STYP_CODE")                // Type of student Applicant will become, need to set to 'G' for New First Term
	private String admissionApplicationStypCode;
	
	@Column(name = "SARADAP_RESD_CODE")                // Residency classification of the applicant
	private String admissionApplicationResdCode;
	
	@Column(name = "SARADAP_ACTIVITY_DATE")            // Date the current record was created or updated
	private Timestamp admissionApplicationActivityDate;

	public Integer getAdmissionApplicationPIDM() {
		return admissionApplicationPIDM;
	}

	public void setAdmissionApplicationPIDM(Integer admissionApplicationPIDM) {
		this.admissionApplicationPIDM = admissionApplicationPIDM;
	}

	public String getAdmissionApplicationTermCodeEntry() {
		return admissionApplicationTermCodeEntry;
	}

	public void setAdmissionApplicationTermCodeEntry(String admissionApplicationTermCodeEntry) {
		this.admissionApplicationTermCodeEntry = admissionApplicationTermCodeEntry;
	}

	public Integer getAdmissionApplicationApplNo() {
		return admissionApplicationApplNo;
	}

	public void setAdmissionApplicationApplNo(Integer admissionApplicationApplNo) {
		this.admissionApplicationApplNo = admissionApplicationApplNo;
	}

	public String getAdmissionApplicationLevlCode() {
		return admissionApplicationLevlCode;
	}

	public void setAdmissionApplicationLevlCode(String admissionApplicationLevlCode) {
		this.admissionApplicationLevlCode = admissionApplicationLevlCode;
	}

	public Timestamp getAdmissionApplicationApplDate() {
		return admissionApplicationApplDate;
	}

	public void setAdmissionApplicationApplDate(Timestamp admissionApplicationApplDate) {
		this.admissionApplicationApplDate = admissionApplicationApplDate;
	}

	public String getAdmissionApplicationApstCode() {
		return admissionApplicationApstCode;
	}

	public void setAdmissionApplicationApstCode(String admissionApplicationApstCode) {
		this.admissionApplicationApstCode = admissionApplicationApstCode;
	}

	public Timestamp getAdmissionApplicationApstDate() {
		return admissionApplicationApstDate;
	}

	public void setAdmissionApplicationApstDate(Timestamp admissionApplicationApstDate) {
		this.admissionApplicationApstDate = admissionApplicationApstDate;
	}

	public String getAdmissionApplicationMaintInd() {
		return admissionApplicationMaintInd;
	}

	public void setAdmissionApplicationMaintInd(String admissionApplicationMaintInd) {
		this.admissionApplicationMaintInd = admissionApplicationMaintInd;
	}

	public String getAdmissionApplicationAdmtCode() {
		return admissionApplicationAdmtCode;
	}

	public void setAdmissionApplicationAdmtCode(String admissionApplicationAdmtCode) {
		this.admissionApplicationAdmtCode = admissionApplicationAdmtCode;
	}

	public String getAdmissionApplicationStypCode() {
		return admissionApplicationStypCode;
	}

	public void setAdmissionApplicationStypCode(String admissionApplicationStypCode) {
		this.admissionApplicationStypCode = admissionApplicationStypCode;
	}

	public String getAdmissionApplicationResdCode() {
		return admissionApplicationResdCode;
	}

	public void setAdmissionApplicationResdCode(String admissionApplicationResdCode) {
		this.admissionApplicationResdCode = admissionApplicationResdCode;
	}

	public Timestamp getAdmissionApplicationActivityDate() {
		return admissionApplicationActivityDate;
	}

	public void setAdmissionApplicationActivityDate(Timestamp admissionApplicationActivityDate) {
		this.admissionApplicationActivityDate = admissionApplicationActivityDate;
	}
	
}
