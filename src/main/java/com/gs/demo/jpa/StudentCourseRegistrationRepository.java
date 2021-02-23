package com.gs.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gs.demo.entity.StudentCourseRegistrationEntity;

@Repository  // SFBETRM table
public interface StudentCourseRegistrationRepository extends JpaRepository<StudentCourseRegistrationEntity, Integer> {

}
