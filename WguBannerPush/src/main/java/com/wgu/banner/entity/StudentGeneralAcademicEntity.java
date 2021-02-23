package com.wgu.banner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sgbstdn", schema = "saturn")            // SGASTDN (General Student Details) banner form
@IdClass(StudentGeneralAcademicEntityKey.class)        // --> SGBSTDN table in banner Oracle for Learner tab/section
public class StudentGeneralAcademicEntity {

	@Id
	@Column(name = "SGBSTDN_PIDM")                     // Primary Key PIDM
	private Integer generalAcademicPIDM;

	@Id
	@Column(name = "SGBSTDN_TERM_CODE_EFF")            // Primary Key New Term Code
	private String generalAcademicTermCodeEFF;

	@Column(name = "SGBSTDN_STST_CODE")                // Student status for New Term need to set 'AS'
	private String generalAcademicStatus;

	@Column(name = "SGBSTDN_STYP_CODE")                // Student type for New Term need to set 'G'
	private String generalAcademicType;
	
	@Column(name = "SGBSTDN_RESD_CODE")                // Residency classification of the student
	private String generalAcademicResd;

	@Column(name = "SGBSTDN_FULL_PART_IND")            // Identifies whether student is Full or Part time, need to set 'F'
	private String generalAcademicFullPartIND;
	
	@Column(name = "SGBSTDN_RATE_CODE")                // Assessment Rate for student set to 'STAND'
	private String generalAcademicFeeRateCode;

	public Integer getGeneralAcademicPIDM() {
		return generalAcademicPIDM;
	}

	public void setGeneralAcademicPIDM(Integer generalAcademicPIDM) {
		this.generalAcademicPIDM = generalAcademicPIDM;
	}

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

	public String getGeneralAcademicType() {
		return generalAcademicType;
	}

	public void setGeneralAcademicType(String generalAcademicType) {
		this.generalAcademicType = generalAcademicType;
	}

	public String getGeneralAcademicResd() {
		return generalAcademicResd;
	}

	public void setGeneralAcademicResd(String generalAcademicResd) {
		this.generalAcademicResd = generalAcademicResd;
	}

	public String getGeneralAcademicFullPartIND() {
		return generalAcademicFullPartIND;
	}

	public void setGeneralAcademicFullPartIND(String generalAcademicFullPartIND) {
		this.generalAcademicFullPartIND = generalAcademicFullPartIND;
	}

	public String getGeneralAcademicFeeRateCode() {
		return generalAcademicFeeRateCode;
	}

	public void setGeneralAcademicFeeRateCode(String generalAcademicFeeRateCode) {
		this.generalAcademicFeeRateCode = generalAcademicFeeRateCode;
	}
	
}
