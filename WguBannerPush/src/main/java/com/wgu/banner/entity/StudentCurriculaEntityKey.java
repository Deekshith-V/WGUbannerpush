package com.wgu.banner.entity;

import java.io.Serializable;

public class StudentCurriculaEntityKey implements Serializable{  // Contains Composite Primary Key for SORLCUR
	private static final long serialVersionUID = 1L;

	private Integer curriculaPIDM;                               // Primary Key PIDM

	private Integer curriculaSeqNo;                              // Primary Key Sequence Number
}
