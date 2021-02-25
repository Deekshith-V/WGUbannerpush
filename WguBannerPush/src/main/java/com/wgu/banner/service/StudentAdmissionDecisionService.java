package com.wgu.banner.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgu.banner.entity.StudentAdmissionApplicationEntity;
import com.wgu.banner.entity.StudentAdmissionDecisionEntity;
import com.wgu.banner.jpa.StudentAdmissionApplicationRepository;
import com.wgu.banner.jpa.StudentAdmissionDecisionRepository;
import com.wgu.banner.model.StudentAdmissionDecisionRequest;

@Service
public class StudentAdmissionDecisionService {
	
private final static Logger logger = LoggerFactory.getLogger(StudentAdmissionDecisionService.class);
	
	@Autowired
	private StudentAdmissionApplicationRepository admissionApplicationrepository;   // SARADAP table

	@Autowired
	private StudentAdmissionDecisionRepository admissionDecisionRepository;   // SARAPPD table
	
	public void saveAdmissionDecision(StudentAdmissionDecisionRequest admissionDecisionRequest) throws Exception{
		
		logger.info("StudentAdmissionDecisionService :: saveAdmissionDecision :: Admission Decision Request in Service "+ admissionDecisionRequest.toString());
		StudentAdmissionDecisionEntity studentAdmissionDecision = new StudentAdmissionDecisionEntity();
		studentAdmissionDecision.setStudentAdmissionDecisionPIDM(admissionDecisionRequest.getStudentAdmissionDecisionPIDM());
		studentAdmissionDecision.setStudentAdmissionDecisionTermCode(admissionDecisionRequest.getStudentAdmissionDecisionTermCode());
		StudentAdmissionApplicationEntity admissionApplicationApplNoGet = admissionApplicationrepository.findByAdmissionApplicationPIDMAndAdmissionApplicationTermCodeEntry(admissionDecisionRequest.getStudentAdmissionDecisionPIDM(), admissionDecisionRequest.getStudentAdmissionDecisionTermCode());
		studentAdmissionDecision.setStudentAdmissionDecisionApplNo(admissionApplicationApplNoGet.getAdmissionApplicationApplNo());          // Setting Application Number 
		StudentAdmissionDecisionEntity admissionDecisionSeqNo = admissionDecisionRepository.findTopByStudentAdmissionDecisionPIDMAndStudentAdmissionDecisionTermCodeOrderByStudentAdmissionDecisionSeqNoDesc(admissionDecisionRequest.getStudentAdmissionDecisionPIDM(), admissionDecisionRequest.getStudentAdmissionDecisionTermCode());
		studentAdmissionDecision.setStudentAdmissionDecisionSeqNo(admissionDecisionSeqNo == null ? 1 : admissionDecisionSeqNo.getStudentAdmissionDecisionSeqNo()+1);            // Setting Sequence Number from Query in Admission Decision Repository
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Setting Date Format
		LocalDateTime presnetDate = LocalDateTime.now();                            // Getting Present Time
		studentAdmissionDecision.setStudentAdmissionDecisionApdcDate(Timestamp.valueOf(dtf.format(presnetDate)));
		studentAdmissionDecision.setStudentAdmissionDecisionApdcCode(admissionDecisionRequest.getStudentAdmissionDecisionApdcCode());
		studentAdmissionDecision.setStudentAdmissionDecisionMaintInd("S");
		studentAdmissionDecision.setStudentAdmissionDecisionActivityDate(Timestamp.valueOf(dtf.format(presnetDate)));
		studentAdmissionDecision.setStudentAdmissionDecisionUser("WGUAAP");
		StudentAdmissionDecisionEntity studentAdmissionDecisionEntity = admissionDecisionRepository.save(studentAdmissionDecision);           // Saving to SARAPPD table
		logger.info("StudentAdmissionDecisionService :: saveAdmissionDecision :: Saving Data to SARAPPD table " + studentAdmissionDecisionEntity.getStudentAdmissionDecisionPIDM());
		
	}
		
	
}
