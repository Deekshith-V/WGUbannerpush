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

import com.wgu.banner.model.StudentGeneralAcademicRequest;
import com.wgu.banner.service.StudentGeneralAcademicService;

@RestController
public class StudentGeneralAcademicController {      // Controller for SGASTDN (General Student Academic Details)
	
	@Autowired
	private StudentGeneralAcademicService generalAcademicService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentGeneralAcademicController.class);
	
	@RequestMapping(value = "/saveGeneralAcademic", method = RequestMethod.POST)
	public ResponseEntity<?> saveGeneralAcademic(@RequestBody StudentGeneralAcademicRequest generalAcademicRequest) {
		logger.info("StudentGeneralAcademicController :: saveGeneralAcademic :: Student General Academic request" + generalAcademicRequest.toString());
		try {
			generalAcademicService.saveGeneralAcademic(generalAcademicRequest);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("StudentGeneralAcademicController :: saveGeneralAcademic :: Exception while saving in database"+e);
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
