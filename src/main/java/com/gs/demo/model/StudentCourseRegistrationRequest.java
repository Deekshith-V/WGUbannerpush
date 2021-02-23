package com.gs.demo.model;

public class StudentCourseRegistrationRequest {
	
	private Integer courseRegistrationPIDM;     // Primary Key PIDM
	private String courseRegistrationTermCode;  // Primary Key NEW Term Code
	private String courseRegistrationESTScode;  // Student Registration Status --> Need to be set to 'EX'
	private String courseRegistrationESTSDate;  // Date the Student Registration Status is changed
	
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
	public String getCourseRegistrationESTSDate() {
		return courseRegistrationESTSDate;
	}
	public void setCourseRegistrationESTSDate(String courseRegistrationESTSDate) {
		this.courseRegistrationESTSDate = courseRegistrationESTSDate;
	}
	
	@Override
	public String toString() {
		return "StudentCourseRegistrationRequest [courseRegistrationPIDM=" + courseRegistrationPIDM
				+ ", courseRegistrationTermCode=" + courseRegistrationTermCode + ", courseRegistrationESTScode="
				+ courseRegistrationESTScode + ", courseRegistrationESTSDate=" + courseRegistrationESTSDate + "]";
	}
	
}
