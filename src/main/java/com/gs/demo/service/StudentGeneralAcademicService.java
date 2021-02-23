package com.gs.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.gs.demo.entity.StudentGeneralAcademicEntity;
import com.gs.demo.jpa.StudentGeneralStudentRepository;
import com.gs.demo.jpa.StudentCurriculaRepository;
import com.gs.demo.model.StudentCurriculaRequest;
import com.gs.demo.model.StudentGeneralAcademicRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentGeneralAcademicService {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentGeneralAcademicService.class);
	//@PersistenceContext
	//private EntityManager entityManager;
	@Autowired
	private StudentGeneralStudentRepository generalStudentRepository;   // SGBSTDN table
	
	@Autowired
	private StudentCurriculaRepository curriculaRepository;             // SORLCUR table
	
	@Autowired
	private StudentCurriculaService curriculaService;                   // Service to send Data to for Curricula tab/section
	
	public void saveSample(StudentGeneralAcademicRequest generalAcademicRequest) throws Exception{
		logger.info("Sample Request in Service" + generalAcademicRequest.toString());
		StudentGeneralAcademicEntity generalStudent = new StudentGeneralAcademicEntity();
		generalStudent.setGeneralAcademicPIDM(generalAcademicRequest.getGeneralAcademicPIDM());
		generalStudent.setGeneralAcademicTermCodeEFF(generalAcademicRequest.getGeneralAcademicTermCodeEFF());
		generalStudent.setGeneralAcademicStatus(generalAcademicRequest.getGeneralAcademicStatus());
		generalStudent.setGeneralAcademicType(generalAcademicRequest.getGeneralAcademicType());
		generalStudent.setGeneralAcademicResd("0");
		generalStudent.setGeneralAcademicFeeRateCode("STAND");
		generalStudent.setGeneralAcademicFullPartIND("F");
		//repository.save(generalStudent);
		StudentGeneralAcademicEntity saveStudent = generalStudentRepository.save(generalStudent);  // Saving Data to SGBSTDN table 
		logger.info("new term code "+ saveStudent.getGeneralAcademicTermCodeEFF());
		
		if(saveStudent != null) {
			StudentCurriculaRequest curriculaRequest = new StudentCurriculaRequest();
			curriculaRequest.setCurriculaPIDM(saveStudent.getGeneralAcademicPIDM());
			curriculaRequest.setCurriculaTermCode(saveStudent.getGeneralAcademicTermCodeEFF());
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
		}
		
	}
}
