package com.gs.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gs.demo.model.StudentCourseRegistrationRequest;
import com.gs.demo.service.StudentCourseRegistrationService;

@RestController
public class StudentCourseRegistrationController {      // Controller for SFAREGS (Course Registration)
	@Autowired
	private StudentCourseRegistrationService registrationService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentCourseRegistrationController.class);
	
	@RequestMapping(value = "/saveCourseRegistration", method = RequestMethod.POST)
	public ResponseEntity<?> saveCourseRegistration(@RequestBody StudentCourseRegistrationRequest courseRegistrationRequest) {
		logger.info("CourseRegistrationController :: saveCourseRegistration :: Course Registration request" + courseRegistrationRequest.toString());
		try {
			registrationService.saveRegistration(courseRegistrationRequest);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("RegistrationController :: saveRegistration :: Exception while saving in database "+e);
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
