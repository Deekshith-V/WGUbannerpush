package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentAdmissionApplicationEntity;

@Repository  // SARADAP table
public interface StudentAdmissionApplicationRepository extends JpaRepository<StudentAdmissionApplicationEntity, Integer>{
	
	public StudentAdmissionApplicationEntity findTopByAdmissionApplicationPIDMOrderByAdmissionApplicationApplNoDesc(Integer admissionApplicationPIDM);
	
	public StudentAdmissionApplicationEntity findByAdmissionApplicationPIDMAndAdmissionApplicationTermCodeEntry(Integer admissionApplicationPIDM, String admissionApplicationTermCodeEntry);

}
