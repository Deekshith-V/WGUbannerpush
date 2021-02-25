package com.wgu.banner.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgu.banner.entity.StudentAdmissionApplicationEntity;
import com.wgu.banner.entity.StudentCurriculaEntity;
import com.wgu.banner.jpa.StudentAdmissionApplicationRepository;
import com.wgu.banner.jpa.StudentCurriculaRepository;
import com.wgu.banner.model.StudentAdmissionApplicationRequest;
import com.wgu.banner.model.StudentCurriculaRequest;

@Service
public class StudentAdmissionApplicationService {
	
	private final static Logger logger = LoggerFactory.getLogger(StudentAdmissionApplicationService.class);
	
	@Autowired
	private StudentAdmissionApplicationRepository admissionApplicationrepository;   // SARADAP table
	
	@Autowired
	private StudentCurriculaRepository curriculaRepository;                         // SORLCUR Table
	
	@Autowired
	private StudentCurriculaService curriculaService;                               // Service to send Data to for Curricula tab/section
	
	public String saveAdmissionApplication(StudentAdmissionApplicationRequest admissionApplicationRequest) throws Exception{
		logger.info("StudentAdmissionApplicationService :: saveAdmissionApplication :: Admission Application Request in Service "+ admissionApplicationRequest.toString());
		StudentAdmissionApplicationEntity applicationExist = admissionApplicationrepository.findByAdmissionApplicationPIDMAndAdmissionApplicationTermCodeEntry(admissionApplicationRequest.getAdmissionApplicationPIDM(), admissionApplicationRequest.getAdmissionApplicationTermCode());
		if(applicationExist != null) {
			logger.info("StudentAdmissionApplicationService :: saveAdmissionApplication :: Student Application Already exists for the term " + applicationExist.getAdmissionApplicationPIDM() + " and " + applicationExist.getAdmissionApplicationTermCodeEntry());
			return "Student Application for that Term already exists";
		}
		else {
			StudentAdmissionApplicationEntity studentAdmissionApplication = new StudentAdmissionApplicationEntity();
			studentAdmissionApplication.setAdmissionApplicationPIDM(admissionApplicationRequest.getAdmissionApplicationPIDM());
			studentAdmissionApplication.setAdmissionApplicationTermCodeEntry(admissionApplicationRequest.getAdmissionApplicationTermCode());
			StudentAdmissionApplicationEntity applicationApplNo = admissionApplicationrepository.findTopByAdmissionApplicationPIDMOrderByAdmissionApplicationApplNoDesc(admissionApplicationRequest.getAdmissionApplicationPIDM());
			studentAdmissionApplication.setAdmissionApplicationApplNo(applicationApplNo.getAdmissionApplicationApplNo()+1);
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
			logger.info("StudentAdmissionApplicationService :: saveAdmissionApplication :: Saved into SARADAP table " + saveStudentAdmissionApplication.getAdmissionApplicationTermCodeEntry());
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
				StudentCurriculaEntity curriculaSeqNo = curriculaRepository.findFirstByCurriculaPIDMOrderByCurriculaSeqNoDesc(saveStudentAdmissionApplication.getAdmissionApplicationPIDM());
				curriculaRequest.setCurriculaSeqNo(curriculaSeqNo.getCurriculaSeqNo()+1);  // Setting Sequence Number from Query in Curricula Repository
				StudentCurriculaEntity curriculaKeySeqNo = curriculaRepository.findFirstByCurriculaPIDMAndCurriculaLmodCodeOrderByCurriculaKeySeqnoDesc(admissionApplicationRequest.getAdmissionApplicationPIDM(), admissionApplicationRequest.getCurriculaLmodCode());
				curriculaRequest.setCurriculaKeySeqNo(curriculaKeySeqNo.getCurriculaKeySeqno()+1); // Incrementing Setting Key Sequence Number from Query in Curricula Repository
				curriculaService.saveCurricula(curriculaRequest);    // Sending data to be saved in SORLCUR table
				logger.info("StudentAdmissionApplicationService :: saveAdmissionApplication :: Passing Data to Student Curricula Service");
				logger.info("StudentAdmissionApplicationService :: saveAdmissionApplication :: Execution completed.");
				return "Student Application saved into Databse";
			}
			
		}
		return null;
	}
}
