package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentAdmissionApplicationEntity;

@Repository  // SARADAP table
public interface StudentAdmissionApplicationRepository extends JpaRepository<StudentAdmissionApplicationEntity, Integer>{
	
	@Query(value = "select max(saradap_appl_no)+1 from saturn.saradap where saradap_pidm = ?1 ", nativeQuery = true)
	public Integer getMaxApplNo(Integer admissionApplicationPIDM); // Using Query above to get max appl_no and increment for new record
	
	public StudentAdmissionApplicationEntity findByAdmissionApplicationPIDMAndAdmissionApplicationTermCodeEntry(Integer admissionApplicationPIDM, String admissionApplicationTermCodeEntry);
}
