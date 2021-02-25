package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentCurriculaEntity;

@Repository   // SORLCUR Table
public interface StudentCurriculaRepository extends JpaRepository<StudentCurriculaEntity, Integer>{
		
	public StudentCurriculaEntity findFirstByCurriculaPIDMOrderByCurriculaSeqNoDesc(Integer curriculaPIDM);
	
	public StudentCurriculaEntity findFirstByCurriculaPIDMAndCurriculaLmodCodeOrderByCurriculaKeySeqnoDesc(Integer curriculaPIDM, String curriculaLmodCode);

}
