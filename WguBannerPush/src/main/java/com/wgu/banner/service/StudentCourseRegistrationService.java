package com.wgu.banner.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgu.banner.entity.StudentCourseRegistrationEntity;
import com.wgu.banner.jpa.StudentCourseRegistrationRepository;
import com.wgu.banner.model.StudentCourseRegistrationRequest;

@Service
public class StudentCourseRegistrationService {
	
	@Autowired
	private StudentCourseRegistrationRepository courseRegistrationRepository;       // SFBETRM table
	
	private final static Logger logger = LoggerFactory.getLogger(StudentAdmissionApplicationService.class);
	
	public void saveCourseRegistration(StudentCourseRegistrationRequest registrationRequest) {
		logger.info("StudentCourseRegistrationService :: saveCourseRegistration :: Registration Request in Service " + registrationRequest.toString());
		StudentCourseRegistrationEntity courseRegistration = new StudentCourseRegistrationEntity();
		courseRegistration.setCourseRegistrationPIDM(registrationRequest.getCourseRegistrationPIDM());
		courseRegistration.setCourseRegistrationTermCode(registrationRequest.getCourseRegistrationTermCode());
		courseRegistration.setCourseRegistrationESTScode(registrationRequest.getCourseRegistrationESTScode());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Setting Date Format
		LocalDateTime formatedRegistrationESTSDate = LocalDateTime.parse(registrationRequest.getCourseRegistrationESTSDate(), dtf); // Formatting ESTS Date
		courseRegistration.setCourseRegistrationESTSDate(Timestamp.valueOf(dtf.format(formatedRegistrationESTSDate)));
		courseRegistration.setCourseRegistrationMhrsOver(99.990);
		courseRegistration.setCourseRegistrationArInd("N");
		LocalDateTime presnetDate = LocalDateTime.now();                            // Getting Present Time
		courseRegistration.setCourseRegistrationAddDate(Timestamp.valueOf(dtf.format(presnetDate)));
		courseRegistration.setCourseRegistrationActivityDate(Timestamp.valueOf(dtf.format(presnetDate)));
		courseRegistration.setCourseRegistrationMinHrs(0.000);
		StudentCourseRegistrationEntity studentCourseRegistrationEntity = courseRegistrationRepository.save(courseRegistration);    // Saving SFBETRM table
		logger.info("StudentCourseRegistrationService :: saveCourseRegistration :: Saving Data into SFBETRM table " + studentCourseRegistrationEntity.getCourseRegistrationPIDM());
	}
	
}
