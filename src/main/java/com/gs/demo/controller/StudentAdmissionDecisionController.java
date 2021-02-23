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

import com.gs.demo.model.StudentAdmissionDecisionRequest;
import com.gs.demo.service.StudentAdmissionDecisionService;

@RestController
public class StudentAdmissionDecisionController {      // Controller for SAADCRV (Admissions Decision)
	
	@Autowired
	private StudentAdmissionDecisionService admissionDecisionService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentAdmissionDecisionController.class);
	
	@RequestMapping(value = "/saveAdmissionDecision", method = RequestMethod.POST)
	public ResponseEntity<?> saveAdmissionDecision(@RequestBody StudentAdmissionDecisionRequest admissionDecisionRequest) {
		logger.info("Admission Decision request " + admissionDecisionRequest.toString());
		try {
			admissionDecisionService.saveAdmissionDecision(admissionDecisionRequest);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Exception while saving in database " + e);
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
