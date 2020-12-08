package com.ssa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.bo.UserRequest;
import com.ssa.constant.AppConstant;
import com.ssa.props.AppProperties;
import com.ssa.service.UserService;

@RestController
@RequestMapping("/proj")

public class SSAEnrollmentController {
	@Autowired
	private UserService service;
	@Autowired
	AppProperties propsMessages;

	@PostMapping(value = "/ssaEnroll", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> enrollUser(@RequestBody UserRequest user) {
		String formatedSsn = null;

		long ssnNo = service.ssnEnrollment(user);

		formatedSsn = formatSSN(ssnNo);

		return new ResponseEntity<String>(propsMessages.getMsg().get(AppConstant.ENROLL_SUCCESS) + formatedSsn,
				HttpStatus.CREATED);

	}

	private String formatSSN(long ssn) {
		String SSNString = String.valueOf(ssn);

		StringBuilder builder = new StringBuilder();

		StringBuilder append = builder.append(SSNString.substring(0, 3)).append("-").append(SSNString.substring(3, 5))
				.append("-").append(SSNString.substring(5, 9));

		return append.toString();

	}
}
