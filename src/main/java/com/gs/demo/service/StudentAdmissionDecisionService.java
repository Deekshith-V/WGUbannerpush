package com.gs.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.demo.entity.StudentAdmissionDecisionEntity;
import com.gs.demo.jpa.StudentAdmissionDecisionRepository;
import com.gs.demo.model.StudentAdmissionDecisionRequest;

@Service
public class StudentAdmissionDecisionService {
	
private final static Logger logger = LoggerFactory.getLogger(StudentAdmissionDecisionService.class);
	
	@Autowired
	private StudentAdmissionDecisionRepository admissionDecisionRepository;   // SARAPPD table
	
	public void saveAdmissionDecision(StudentAdmissionDecisionRequest admissionDecisionRequest) throws Exception{
		
		logger.info("Admission Decision Request in Service "+ admissionDecisionRequest.toString());
		StudentAdmissionDecisionEntity studentAdmissionDecision = new StudentAdmissionDecisionEntity();
		studentAdmissionDecision.setStudentAdmissionDecisionPIDM(admissionDecisionRequest.getStudentAdmissionDecisionPIDM());
		studentAdmissionDecision.setStudentAdmissionDecisionTermCode(admissionDecisionRequest.getStudentAdmissionDecisionTermCode());
		Integer admissionDecisionApplNo = admissionDecisionRepository.getMaxApplNo(admissionDecisionRequest.getStudentAdmissionDecisionPIDM());
		studentAdmissionDecision.setStudentAdmissionDecisionApplNo(admissionDecisionApplNo);          // Setting Application Number from Query in Admission Decision Repository
		Integer admissionDecisionSeqNo = admissionDecisionRepository.getMaxSeqNo(admissionDecisionRequest.getStudentAdmissionDecisionPIDM(), admissionDecisionRequest.getStudentAdmissionDecisionTermCode());
		logger.info("Admission Decision Seq No in Service "+admissionDecisionSeqNo);                  
		admissionDecisionSeqNo = admissionDecisionSeqNo == null ? 1 : admissionDecisionSeqNo;         // If Sequence Number is NULL representing new record, set SeqNo to 1
		studentAdmissionDecision.setStudentAdmissionDecisionSeqNo(admissionDecisionSeqNo);            // Setting Sequence Number from Query in Admission Decision Repository
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Setting Date Format
		LocalDateTime presnetDate = LocalDateTime.now();                            // Getting Present Time
		studentAdmissionDecision.setStudentAdmissionDecisionApdcDate(Timestamp.valueOf(dtf.format(presnetDate)));
		studentAdmissionDecision.setStudentAdmissionDecisionApdcCode(admissionDecisionRequest.getStudentAdmissionDecisionApdcCode());
		studentAdmissionDecision.setStudentAdmissionDecisionMaintInd("S");
		studentAdmissionDecision.setStudentAdmissionDecisionActivityDate(Timestamp.valueOf(dtf.format(presnetDate)));
		studentAdmissionDecision.setStudentAdmissionDecisionUser("WGUAAP");
		admissionDecisionRepository.save(studentAdmissionDecision);           // Saving to SARAPPD table
		
		
	}
		
	
}
