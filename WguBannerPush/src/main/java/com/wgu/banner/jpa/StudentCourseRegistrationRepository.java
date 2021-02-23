package com.wgu.banner.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wgu.banner.entity.StudentCourseRegistrationEntity;

@Repository  // SFBETRM table
public interface StudentCourseRegistrationRepository extends JpaRepository<StudentCourseRegistrationEntity, Integer> {

}
