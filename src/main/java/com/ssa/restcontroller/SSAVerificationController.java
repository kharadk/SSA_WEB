package com.ssa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.bo.UserResponse;
import com.ssa.service.UserService;

@RestController
@RequestMapping("/verify")
public class SSAVerificationController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/{ssnNo}")

	public ResponseEntity<UserResponse> validateUser(@PathVariable Long ssnNo) {

		UserResponse userDataBySSN = service.getUserDataBySSN(ssnNo);

		return new ResponseEntity<UserResponse>(userDataBySSN, HttpStatus.OK);
	}
}
