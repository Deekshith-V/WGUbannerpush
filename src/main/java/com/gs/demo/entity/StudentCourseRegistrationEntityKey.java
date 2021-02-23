package com.gs.demo.entity;

import java.io.Serializable;

public class StudentCourseRegistrationEntityKey implements Serializable{  // Contains the Composite Primary Key for SFBETRM

	private static final long serialVersionUID = 1L;

	private Integer courseRegistrationPIDM;                                     //  Primary Key PIDM

	private String courseRegistrationTermCode;                                  // Primary Key NEW Term Code
}
