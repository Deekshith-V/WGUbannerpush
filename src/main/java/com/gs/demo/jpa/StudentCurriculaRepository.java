package com.gs.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gs.demo.entity.StudentCurriculaEntity;

@Repository   // SORLCUR Table
public interface StudentCurriculaRepository extends JpaRepository<StudentCurriculaEntity, Integer>{
	
	@Query(value = "select max(sorlcur_seqno)+1 from saturn.sorlcur where sorlcur_pidm = ?1", nativeQuery = true)
	public Integer getMaxPIDM(Integer curriculaPIDM);  // Using Query above to get max SeqNo and increment it for the new record
	
	@Query(value = "select max(sorlcur_key_seqno) from saturn.sorlcur where sorlcur_pidm = ?1 and sorlcur_lmod_code = ?2", nativeQuery = true)
	public Integer getMaxKeySeqNo(Integer curriculaPIDM, String curriculaLmodCode);
}
