package com.wgu.banner.entity;

import java.io.Serializable;

public class StudentAdmissionDecisionEntityKey implements Serializable{  // Contains the Composite Primary Key for SARAPPD

	private static final long serialVersionUID = 1L;

	private Integer studentAdmissionDecisionPIDM;                        // Primary Key PIDM
	
	private String studentAdmissionDecisionTermCode;                     // Primary Key New Term Code
	
	private Integer studentAdmissionDecisionApplNo;                      // Primary Key Application Number for the Term
	
	private Integer studentAdmissionDecisionSeqNo;                       // Primary Key Sequence Number is internal sequence number for the 'i'th Decision Code
	
}
