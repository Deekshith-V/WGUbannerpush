package com.wgu.banner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wgu.banner.model.StudentAdmissionApplicationRequest;
import com.wgu.banner.service.StudentAdmissionApplicationService;

@RestController
public class StudentAdmissionApplicationController {       // Controller for SAAADMS (Admission Application)
	
	@Autowired
	private StudentAdmissionApplicationService admissionApplicationService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentAdmissionApplicationController.class);
	
	@RequestMapping(value = "/saveAdmissionApplication", method = RequestMethod.POST)
	public ResponseEntity<?> saveAdmissionApplication(@RequestBody StudentAdmissionApplicationRequest admissionApplicationRequest) {
		logger.info("StudentAdmissionApplicationController :: saveAdmissionApplication :: Admission Application request " + admissionApplicationRequest.toString());
		try {
			String saveAdmissionApplication = admissionApplicationService.saveAdmissionApplication(admissionApplicationRequest);
			return new ResponseEntity<String>(saveAdmissionApplication, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("StudentAdmissionApplicationController :: saveAdmissionApplication :: Exception while saving in database " + e);
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
