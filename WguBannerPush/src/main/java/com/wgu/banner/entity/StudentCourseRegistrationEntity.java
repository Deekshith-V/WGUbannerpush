package com.wgu.banner.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sfbetrm", schema = "saturn")         // SFAREGS (Student Course Registration) banner form --> SFBETRM table in Banner Oracle
@IdClass(StudentCourseRegistrationEntityKey.class)
public class StudentCourseRegistrationEntity {
	
	@Id
	@Column(name = "SFBETRM_PIDM")                  // Primary Key PIDM
	private Integer courseRegistrationPIDM;
	
	@Id
	@Column(name = "SFBETRM_TERM_CODE")             // Primary Key NEW Term Code
	private String courseRegistrationTermCode;
	
	@Column(name = "SFBETRM_ESTS_CODE")             // Student Registration Status --> Need to be set to 'EX'
	private String courseRegistrationESTScode;
	
	@Column(name = "SFBETRM_ESTS_DATE")             // Date the Student Registration Status is changed
	private Timestamp courseRegistrationESTSDate;
	
	@Column(name = "SFBETRM_MHRS_OVER")             // Maximum Hours for this New Term
	private Double courseRegistrationMhrsOver;
	
	@Column(name = "SFBETRM_AR_IND")                // Term charges acceptance indicator
	private String courseRegistrationArInd;
	
	@Column(name = "SFBETRM_ADD_DATE")              // Date of initial Registration of this Term
	private Timestamp courseRegistrationAddDate;
	
	@Column(name = "SFBETRM_ACTIVITY_DATE")         // Date the current record was created or updated
	private Timestamp courseRegistrationActivityDate;
	
	@Column(name = "SFBETRM_MIN_HRS")               // Minimum Hours for this New Term
	private Double courseRegistrationMinHrs;

	public Integer getCourseRegistrationPIDM() {
		return courseRegistrationPIDM;
	}

	public void setCourseRegistrationPIDM(Integer courseRegistrationPIDM) {
		this.courseRegistrationPIDM = courseRegistrationPIDM;
	}

	public String getCourseRegistrationTermCode() {
		return courseRegistrationTermCode;
	}

	public void setCourseRegistrationTermCode(String courseRegistrationTermCode) {
		this.courseRegistrationTermCode = courseRegistrationTermCode;
	}

	public String getCourseRegistrationESTScode() {
		return courseRegistrationESTScode;
	}

	public void setCourseRegistrationESTScode(String courseRegistrationESTScode) {
		this.courseRegistrationESTScode = courseRegistrationESTScode;
	}

	public Timestamp getCourseRegistrationESTSDate() {
		return courseRegistrationESTSDate;
	}

	public void setCourseRegistrationESTSDate(Timestamp courseRegistrationESTSDate) {
		this.courseRegistrationESTSDate = courseRegistrationESTSDate;
	}

	public Double getCourseRegistrationMhrsOver() {
		return courseRegistrationMhrsOver;
	}

	public void setCourseRegistrationMhrsOver(Double courseRegistrationMhrsOver) {
		this.courseRegistrationMhrsOver = courseRegistrationMhrsOver;
	}

	public String getCourseRegistrationArInd() {
		return courseRegistrationArInd;
	}

	public void setCourseRegistrationArInd(String courseRegistrationArInd) {
		this.courseRegistrationArInd = courseRegistrationArInd;
	}

	public Timestamp getCourseRegistrationAddDate() {
		return courseRegistrationAddDate;
	}

	public void setCourseRegistrationAddDate(Timestamp courseRegistrationAddDate) {
		this.courseRegistrationAddDate = courseRegistrationAddDate;
	}

	public Timestamp getCourseRegistrationActivityDate() {
		return courseRegistrationActivityDate;
	}

	public void setCourseRegistrationActivityDate(Timestamp courseRegistrationActivityDate) {
		this.courseRegistrationActivityDate = courseRegistrationActivityDate;
	}

	public Double getCourseRegistrationMinHrs() {
		return courseRegistrationMinHrs;
	}

	public void setCourseRegistrationMinHrs(Double courseRegistrationMinHrs) {
		this.courseRegistrationMinHrs = courseRegistrationMinHrs;
	}
	
}
