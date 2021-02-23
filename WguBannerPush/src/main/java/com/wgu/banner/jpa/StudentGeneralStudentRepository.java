package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentGeneralAcademicEntity;

@Repository  // SGASTDN table
public interface StudentGeneralStudentRepository extends JpaRepository<StudentGeneralAcademicEntity, Integer> {
	
	//public GeneralStudent findFirst1OrderBySGBSTDNPIDMdesc();
}