package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentAdmissionDecisionEntity;

@Repository  // SARAPPD table
public interface StudentAdmissionDecisionRepository extends JpaRepository<StudentAdmissionDecisionEntity, Integer>{
		
	public StudentAdmissionDecisionEntity findTopByStudentAdmissionDecisionPIDMAndStudentAdmissionDecisionTermCodeOrderByStudentAdmissionDecisionSeqNoDesc(Integer studentAdmissionDecisionPIDM, String studentAdmissionDecisionTermCode);
	
}
