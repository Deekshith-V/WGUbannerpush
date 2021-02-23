package com.wgu.banner.service;


import org.springframework.beans.factory.annotation.Autowired;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.wgu.banner.entity.StudentGeneralAcademicEntity;
import com.wgu.banner.jpa.StudentCurriculaRepository;
import com.wgu.banner.jpa.StudentGeneralStudentRepository;
import com.wgu.banner.model.StudentCurriculaRequest;
import com.wgu.banner.model.StudentGeneralAcademicRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentGeneralAcademicService {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentGeneralAcademicService.class);
	
	@Autowired
	private StudentGeneralStudentRepository generalStudentRepository;   // SGBSTDN table
	
	@Autowired
	private StudentCurriculaRepository curriculaRepository;             // SORLCUR table
	
	@Autowired
	private StudentCurriculaService curriculaService;                   // Service to send Data to for Curricula tab/section
	
	public void saveGeneralAcademic(StudentGeneralAcademicRequest generalAcademicRequest) throws Exception{
		logger.info("StudentGeneralAcademicService :: saveGeneralAcademic :: General Academic Request in Service " + generalAcademicRequest.toString());
		StudentGeneralAcademicEntity generalStudent = new StudentGeneralAcademicEntity();
		generalStudent.setGeneralAcademicPIDM(generalAcademicRequest.getGeneralAcademicPIDM());
		generalStudent.setGeneralAcademicTermCodeEFF(generalAcademicRequest.getGeneralAcademicTermCodeEFF());
		generalStudent.setGeneralAcademicStatus(generalAcademicRequest.getGeneralAcademicStatus());
		generalStudent.setGeneralAcademicType(generalAcademicRequest.getGeneralAcademicType());
		generalStudent.setGeneralAcademicResd("0");
		generalStudent.setGeneralAcademicFeeRateCode("STAND");
		generalStudent.setGeneralAcademicFullPartIND("F");
		StudentGeneralAcademicEntity saveGeneralAcademicEntity = generalStudentRepository.save(generalStudent);  // Saving Data to SGBSTDN table 
		logger.info("StudentGeneralAcademicService :: saveGeneralAcademic :: Saving Data into SGBSTDN table "+ saveGeneralAcademicEntity.getGeneralAcademicPIDM());
		
		if(saveGeneralAcademicEntity != null) {
			StudentCurriculaRequest curriculaRequest = new StudentCurriculaRequest();
			curriculaRequest.setCurriculaPIDM(saveGeneralAcademicEntity.getGeneralAcademicPIDM());
			curriculaRequest.setCurriculaTermCode(saveGeneralAcademicEntity.getGeneralAcademicTermCodeEFF());
			curriculaRequest.setCurriculaCodeCtlg(generalAcademicRequest.getCurriculaCodeCtlg());
			curriculaRequest.setCurriculaProgramCode(generalAcademicRequest.getCurriculaProgramCode());
			curriculaRequest.setCurriculaCampCode(generalAcademicRequest.getCurriculaCampCode());
			curriculaRequest.setCurriculaLevlCode(generalAcademicRequest.getCurriculaLevlCode());
			curriculaRequest.setCurriculaCollCode(generalAcademicRequest.getCurriculaCollCode());
			curriculaRequest.setCurriculaDegcCode(generalAcademicRequest.getCurriculaDegcCode());
			curriculaRequest.setCurriculaLmodCode(generalAcademicRequest.getCurriculaLmodCode());
			curriculaRequest.setCurriculaRollInd("Y");
			Integer curriculaSeqNo = curriculaRepository.getMaxPIDM(curriculaRequest.getCurriculaPIDM());
			curriculaRequest.setCurriculaSeqNo(curriculaSeqNo);  // Setting Sequence Number from Query in Curricula Repository
			Integer curriculaKeySeqNo = curriculaRepository.getMaxKeySeqNo(generalAcademicRequest.getGeneralAcademicPIDM(), generalAcademicRequest.getCurriculaLmodCode());
			curriculaRequest.setCurriculaKeySeqNo(curriculaKeySeqNo);  // Setting Key Sequence Number from Query in Curricula Repository
			curriculaService.saveCurricula(curriculaRequest);    // Sending data to be saved in SORLCUR table
			logger.info("StudentGeneralAcademicService :: saveGeneralAcademic :: Passing Data to Student Curricula Service");
		}
		logger.info("StudentGeneralAcademicService :: saveGeneralAcademic :: Execution Completed.");
	}
}
