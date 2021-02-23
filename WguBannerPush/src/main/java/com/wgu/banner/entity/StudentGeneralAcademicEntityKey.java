package com.wgu.banner.entity;

import java.io.Serializable;

public class StudentGeneralAcademicEntityKey implements Serializable{  // Contains Composite Primary Key for SGBSTDN
	private static final long serialVersionUID = 1L;

	private Integer generalAcademicPIDM;                               // Primary Key PIDM

	private String generalAcademicTermCodeEFF;                         // Primary Key New Term Code
}
