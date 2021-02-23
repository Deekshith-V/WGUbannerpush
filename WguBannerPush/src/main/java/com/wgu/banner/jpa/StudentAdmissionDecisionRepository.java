package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentAdmissionDecisionEntity;

@Repository  // SARAPPD table
public interface StudentAdmissionDecisionRepository extends JpaRepository<StudentAdmissionDecisionEntity, Integer>{
	
	@Query(value = "select max(sarappd_appl_no)+1 from saturn.sarappd where sarappd_pidm = ?1 ", nativeQuery = true)
	public Integer getMaxApplNo(Integer studentAdmissionDecisionPIDM); // Using Query above to get max ApplNo for the PIDM and increment it for new record
	
	@Query(value = "select max(sarappd_seq_no)+1 from saturn.sarappd where sarappd_pidm = ?1 and sarappd_term_code_entry = ?2 ", nativeQuery = true)
	public Integer getMaxSeqNo(Integer studentAdmissionDecisionPIDM, String studentAdmissionDecisionTermCode); // Using Query above to get max SeqNo for the PIDM and Term, and increment it for the new record
	
	
}
