package com.wgu.banner.entity;

import java.io.Serializable;

public class StudentAdmissionApplicationEntityKey implements Serializable{  // Contains Composite Primary Key for SARADAP
	private static final long serialVersionUID = 1L;

	private Integer admissionApplicationPIDM;                               // Primary Key PIDM
	
	private String admissionApplicationTermCodeEntry;                       // Primary Key New Term Code
	
	private Integer admissionApplicationApplNo;                             // Primary Key Application Number for the Term
	
	
}
