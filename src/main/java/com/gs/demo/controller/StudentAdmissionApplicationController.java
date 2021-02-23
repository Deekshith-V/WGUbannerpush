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

import com.gs.demo.model.StudentAdmissionApplicationRequest;
import com.gs.demo.service.StudentAdmissionApplicationService;

@RestController
public class StudentAdmissionApplicationController {       // Controller for SAAADMS (Admission Application)
	
	@Autowired
	private StudentAdmissionApplicationService admissionApplicationService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentAdmissionApplicationController.class);
	
	@RequestMapping(value = "/saveAdmissionApplication", method = RequestMethod.POST)
	public ResponseEntity<?> saveAdmissionApplication(@RequestBody StudentAdmissionApplicationRequest admissionApplicationRequest) {
		logger.info("Admission Application request " + admissionApplicationRequest.toString());
		try {
			admissionApplicationService.saveAdmissionApplication(admissionApplicationRequest);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Exception while savind in database " + e);
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
