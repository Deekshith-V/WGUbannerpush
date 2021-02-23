package com.gs.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.demo.entity.StudentCurriculaEntity;
import com.gs.demo.jpa.StudentCurriculaRepository;
import com.gs.demo.model.StudentCurriculaRequest;

@Service
public class StudentCurriculaService {
	
	@Autowired
	private StudentCurriculaRepository curriculaRepository;    // SORLCUR table
	
//	private final static Logger logger = LoggerFactory.getLogger(AdmissionApplicationService.class);
	
	public void saveCurricula(StudentCurriculaRequest curriculaRequest) {
		StudentCurriculaEntity studentCurricula = new StudentCurriculaEntity();
		studentCurricula.setCurriculaPIDM(curriculaRequest.getCurriculaPIDM());
		studentCurricula.setCurriculaCampCode(curriculaRequest.getCurriculaCampCode());
		studentCurricula.setCurriculaCodeCTLG(curriculaRequest.getCurriculaCodeCtlg());
		studentCurricula.setCurriculaProgram(curriculaRequest.getCurriculaProgramCode());
		studentCurricula.setCurriculaLmodCode(curriculaRequest.getCurriculaLmodCode());
		studentCurricula.setCurriculaTermCode(curriculaRequest.getCurriculaTermCode());
		studentCurricula.setCurriculaKeySeqno(curriculaRequest.getCurriculaKeySeqNo());
		studentCurricula.setCurriculaPriorityNo(1);
		studentCurricula.setCurriculaRollind(curriculaRequest.getCurriculaRollInd());
		studentCurricula.setCurriculaSeqNo(curriculaRequest.getCurriculaSeqNo());
		studentCurricula.setCurriculaCactCode("ACTIVE");
		studentCurricula.setCurriculaUserId("MROGERS2");
		studentCurricula.setCurriculaDataOrgin("Banner");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Setting Date Format
		LocalDateTime presnetDate = LocalDateTime.now();                            // Getting Present Time
		studentCurricula.setCurriculaActivityDate(Timestamp.valueOf(dtf.format(presnetDate)));
		studentCurricula.setCurriculaLevlCode(curriculaRequest.getCurriculaLevlCode());
		studentCurricula.setCurriculaCollCode(curriculaRequest.getCurriculaCollCode());
		studentCurricula.setCurriculaDegCode(curriculaRequest.getCurriculaDegcCode());
		studentCurricula.setCurriculaCurrentCDE("Y"); 
		curriculaRepository.save(studentCurricula);            // Saving SORLCUR table
	}
}
