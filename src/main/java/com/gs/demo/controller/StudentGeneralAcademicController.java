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

import com.gs.demo.model.StudentGeneralAcademicRequest;
import com.gs.demo.service.StudentGeneralAcademicService;

@RestController
public class StudentGeneralAcademicController {      // Controller for SGASTDN (General Student Academic Details)
	
	@Autowired
	private StudentGeneralAcademicService sampleService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentGeneralAcademicController.class);
	
	@RequestMapping(value = "/saveGeneralAcademic", method = RequestMethod.POST)
	public ResponseEntity<?> saveGeneralAcademic(@RequestBody StudentGeneralAcademicRequest generalAcademicRequest) {
		logger.info("Sample request" + generalAcademicRequest.toString());
		try {
			sampleService.saveSample(generalAcademicRequest);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception while saving in database"+e);
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
