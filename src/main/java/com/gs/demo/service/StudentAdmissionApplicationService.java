package com.gs.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.demo.entity.StudentAdmissionApplicationEntity;
import com.gs.demo.jpa.StudentAdmissionApplicationRepository;
import com.gs.demo.jpa.StudentCurriculaRepository;
import com.gs.demo.model.StudentAdmissionApplicationRequest;
import com.gs.demo.model.StudentCurriculaRequest;

@Service
public class StudentAdmissionApplicationService {
	
	private final static Logger logger = LoggerFactory.getLogger(StudentAdmissionApplicationService.class);
	
	@Autowired
	private StudentAdmissionApplicationRepository admissionApplicationrepository;   // SARADAP table
	
	@Autowired
	private StudentCurriculaRepository curriculaRepository;                         // SORLCUR Table
	
	@Autowired
	private StudentCurriculaService curriculaService;                               // Service to send Data to for Curricula tab/section
	
	public void saveAdmissionApplication(StudentAdmissionApplicationRequest admissionApplicationRequest) throws Exception{
		logger.info("Admission Application Request in Service "+ admissionApplicationRequest.toString());
		StudentAdmissionApplicationEntity studentAdmissionApplication = new StudentAdmissionApplicationEntity();
		studentAdmissionApplication.setAdmissionApplicationPIDM(admissionApplicationRequest.getAdmissionApplicationPIDM());
		studentAdmissionApplication.setAdmissionApplicationTermCodeEntry(admissionApplicationRequest.getAdmissionApplicationTermCode());
		Integer admissionApplicationApplNo = admissionApplicationrepository.getMaxApplNo(admissionApplicationRequest.getAdmissionApplicationPIDM());
		studentAdmissionApplication.setAdmissionApplicationApplNo(admissionApplicationApplNo);                   // Setting Application Number from Query in Admission Application Repository
		studentAdmissionApplication.setAdmissionApplicationLevlCode(admissionApplicationRequest.getCurriculaLevlCode());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Setting Date Format
		LocalDateTime presnetDate = LocalDateTime.now();                            // Getting Present Time
		studentAdmissionApplication.setAdmissionApplicationApplDate(Timestamp.valueOf(dtf.format(presnetDate))); // Setting Present Date for Application Record
		studentAdmissionApplication.setAdmissionApplicationApstCode("C");
		studentAdmissionApplication.setAdmissionApplicationApstDate(Timestamp.valueOf(dtf.format(presnetDate))); // Setting Present Date associated with most current status of application
		studentAdmissionApplication.setAdmissionApplicationMaintInd("S");
		studentAdmissionApplication.setAdmissionApplicationAdmtCode("ST");
		studentAdmissionApplication.setAdmissionApplicationStypCode(admissionApplicationRequest.getAdmissionApplicationStypCode());
		studentAdmissionApplication.setAdmissionApplicationResdCode("0");
		studentAdmissionApplication.setAdmissionApplicationActivityDate(Timestamp.valueOf(dtf.format(presnetDate)));
		StudentAdmissionApplicationEntity saveStudentAdmissionApplication = admissionApplicationrepository.save(studentAdmissionApplication);  // Saving Data to SARADAP table 
		logger.info("New term code " + saveStudentAdmissionApplication.getAdmissionApplicationTermCodeEntry() + ", New Student type " + saveStudentAdmissionApplication.getAdmissionApplicationStypCode());
		
		if(saveStudentAdmissionApplication != null) {
			StudentCurriculaRequest curriculaRequest = new StudentCurriculaRequest(); 
			curriculaRequest.setCurriculaPIDM(saveStudentAdmissionApplication.getAdmissionApplicationPIDM());
			curriculaRequest.setCurriculaTermCode(saveStudentAdmissionApplication.getAdmissionApplicationTermCodeEntry());
			curriculaRequest.setCurriculaCodeCtlg(admissionApplicationRequest.getCurriculaCodeCtlg());
			curriculaRequest.setCurriculaProgramCode(admissionApplicationRequest.getCurriculaProgramCode());
			curriculaRequest.setCurriculaCampCode(admissionApplicationRequest.getCurriculaCampCode());
			curriculaRequest.setCurriculaLevlCode(admissionApplicationRequest.getCurriculaLevlCode());
			curriculaRequest.setCurriculaCollCode(admissionApplicationRequest.getCurriculaCollCode());
			curriculaRequest.setCurriculaDegcCode(admissionApplicationRequest.getCurriculaDegcCode());
			curriculaRequest.setCurriculaLmodCode(admissionApplicationRequest.getCurriculaLmodCode());
			curriculaRequest.setCurriculaRollInd("N");
			Integer curriculaSeqNo = curriculaRepository.getMaxPIDM(saveStudentAdmissionApplication.getAdmissionApplicationPIDM());
			curriculaRequest.setCurriculaSeqNo(curriculaSeqNo);  // Setting Sequence Number from Query in Curricula Repository
			Integer curriculaKeySeqNo = curriculaRepository.getMaxKeySeqNo(admissionApplicationRequest.getAdmissionApplicationPIDM(), admissionApplicationRequest.getCurriculaLmodCode());
			curriculaRequest.setCurriculaKeySeqNo(curriculaKeySeqNo+1); // Incrementing Setting Key Sequence Number from Query in Curricula Repository
			curriculaService.saveCurricula(curriculaRequest);    // Sending data to be saved in SORLCUR table
		}
		
	}
}
