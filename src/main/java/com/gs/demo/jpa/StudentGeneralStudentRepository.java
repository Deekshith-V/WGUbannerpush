package com.gs.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gs.demo.entity.StudentGeneralAcademicEntity;

@Repository  // SGASTDN table
public interface StudentGeneralStudentRepository extends JpaRepository<StudentGeneralAcademicEntity, Integer> {
	
	//public GeneralStudent findFirst1OrderBySGBSTDNPIDMdesc();
}